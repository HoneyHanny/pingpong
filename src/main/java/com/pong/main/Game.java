package com.pong.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private static Thread thread;
	
	public static final String TITLE = "Pong";
	public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int WIDTH = screenSize.width;
	public static final int HEIGHT = screenSize.height;

	public enum STATE {
		Menu, Pause, OnePlayer, TwoPlayer, Settings, PauseSettings, AfterMatch, SelectPlayer
	}

	public static STATE gameState;
	
	public static boolean fps;
	public static int ticks;
	public static int frames;
	public static int prevframes;
	
	public static boolean running;
	public static boolean scored;
	public static boolean lscored;
	public static boolean rscored;

	public static Handler handler;
	public static Menu menu;
	public static Graphics g;

	public static Score score;
	public static Ball ball;

	public Game() {

		Game.fps = false;

		handler = new Handler();
		menu = new Menu();
		score = new Score();

		new Window(this, TITLE);
		addKeyListener(new KeyInput());
		addMouseListener(menu);
		
		gameState = STATE.Menu;

	}
	
	@Override
	public void run() {
		requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				tick();
				delta--;
			}

			if (running) {
				render();
				frames++;
			}

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				prevframes = frames;
				frames = 0;
			}
		}
	}

	public synchronized void start() {
		if (running)
			return;
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	@SuppressWarnings("unused")
	private synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final void tick() {
		if (gameState == Game.STATE.Menu || gameState == Game.STATE.SelectPlayer || gameState == Game.STATE.Pause) {
			menu.tick();
		} else if (gameState == STATE.OnePlayer || gameState == STATE.TwoPlayer) {
			handler.tick();
			score.tick();
		}
	}

	private final void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		Game.g = g;
		/* ------------------ v Start draw v ------------------ */

		if (gameState == Game.STATE.Menu || gameState == Game.STATE.SelectPlayer || gameState == Game.STATE.Pause) {
			// draw background
			g.setColor(new Color(71, 71, 71));
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
			// draw menu
			menu.render(g);
		} else if (gameState == Game.STATE.OnePlayer || gameState == Game.STATE.TwoPlayer) {
			// draw background
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

			// draw game objects
			handler.render(g);
			score.render(g);

			// draw center line                 x1     y1     x2       y2
			GameUtilities.drawDashedLine(g, WIDTH / 2, 0, WIDTH / 2, HEIGHT);
		}

		// display fps
		if (fps)
			GameUtilities.DisplayFramesPerSecond(g);
		
		/* ------------------ ^ End draw ^ ------------------ */
		g.dispose();
		bs.show();
	}

	public static final void main(String[] args) {
		new Game();
	}
	
}
