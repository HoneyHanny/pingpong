package com.pong.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu implements MouseListener {

	private static int mx;
	private static int my;

	// private static int xPos = 0;
	private static int yDisplace = 0;

	private static FontMetrics fontMetrics;
	private static Point mouseCoord;

	public static Game.STATE prevState;

	private static ScreenText play;
	private static ScreenText quit;
	private static ScreenText onePlayer;
	private static ScreenText twoPlayer;
	private static ScreenText back;
	private static ScreenText resume;
	private static ScreenText menu;

	// private static Graphics g = Game.g;

	public void tick() {
		mouseCoord = MouseInfo.getPointerInfo().getLocation();
		mx = mouseCoord.x;
		my = mouseCoord.y;

		yDisplace = (int) (Math.cos((System.currentTimeMillis()) * Math.PI / 1000) * 5);
	}

	public void render(Graphics g) {
		
		if (Game.gameState == Game.STATE.Menu) { // ------------------- STATE.Menu
			
			g.setFont(new Font("Aquire", Font.PLAIN, 80));

			int x = GameUtilities.centerStringX(g, Game.TITLE);
			g.setColor(Color.WHITE);
			g.drawString(Game.TITLE, x, 250); // title text white
			g.setColor(new Color(31, 31, 31));
			g.drawString(Game.TITLE, x + 1, 251); // title text gray
	
			g.setFont(new Font("Aquire", Font.PLAIN, 60));
			fontMetrics = g.getFontMetrics();

			play = GameUtilities.getScreenText(g, fontMetrics, "Play", 400 + yDisplace);
			quit = GameUtilities.getScreenText(g, fontMetrics, "Quit", 500 + yDisplace);
	
			if (mouseOver(mx, my, play.x, play.y, play.width, play.height)) { // * play mouse over condition
				g.setColor(Color.WHITE);
				g.drawString(play.str, GameUtilities.centerStringX(g, play.str), play.y + play.height); // play text white

				g.setColor(new Color(31, 31, 31));
				g.drawString(quit.str, GameUtilities.centerStringX(g, quit.str), quit.y + quit.height); // quit text white

			} else if (mouseOver(mx, my, quit.x, quit.y, quit.width, quit.height)) { // * quit mouse over condition
				g.setColor(Color.WHITE);
				g.drawString(quit.str, GameUtilities.centerStringX(g, quit.str), quit.y + quit.height); // quit text white

				g.setColor(new Color(31, 31, 31));
				g.drawString(play.str, GameUtilities.centerStringX(g, play.str), play.y + play.height); // play text white

			} else { // * no mouse over condition

				g.drawString(play.str, GameUtilities.centerStringX(g, play.str), play.y + play.height); // play text gray
				g.drawString(quit.str, GameUtilities.centerStringX(g, quit.str), quit.y + quit.height); // quit text gray

			}

			g.setFont(new Font("Aquire", Font.PLAIN, 20));
			g.drawString("Developed by Hans Duran", 30, Game.HEIGHT - 15);
			
		} else if (Game.gameState == Game.STATE.SelectPlayer) { // ------------------- STATE.SelectPlayer

			g.setFont(new Font("Aquire", Font.PLAIN, 80));

			int x = GameUtilities.centerStringX(g, Game.TITLE);
			g.setColor(Color.WHITE);
			g.drawString(Game.TITLE, x, 250); // title text white
			g.setColor(new Color(31, 31, 31));
			g.drawString(Game.TITLE, x + 1, 251); // title text gray
			
			g.setFont(new Font("Aquire", Font.PLAIN, 60));
			fontMetrics = g.getFontMetrics();

			onePlayer = GameUtilities.getScreenText(g, fontMetrics, "1 Player", 400 + yDisplace);
			twoPlayer = GameUtilities.getScreenText(g, fontMetrics, "2 Players", 500 + yDisplace);
			back = GameUtilities.getScreenText(g, fontMetrics, "Back", 600 + yDisplace);

			if (mouseOver(mx, my, onePlayer.x, onePlayer.y, onePlayer.width, onePlayer.height)) { // * 1 player mouse over condition
				g.setColor(Color.WHITE);
				g.drawString(onePlayer.str, GameUtilities.centerStringX(g, onePlayer.str), onePlayer.y + onePlayer.height); // 1 player text white

				g.setColor(new Color(31, 31, 31));

				g.drawString(twoPlayer.str, GameUtilities.centerStringX(g, twoPlayer.str), twoPlayer.y + twoPlayer.height); // 2 players text white
				g.drawString(back.str, GameUtilities.centerStringX(g, back.str), back.y + back.height); // back text

			} else if (mouseOver(mx, my, twoPlayer.x, twoPlayer.y, twoPlayer.width, twoPlayer.height)) { // * 2 players mouse over condition
				g.setColor(Color.WHITE);
				g.drawString(twoPlayer.str, GameUtilities.centerStringX(g, twoPlayer.str), twoPlayer.y + twoPlayer.height); // 2 players text white

				g.setColor(new Color(31, 31, 31));

				g.drawString(onePlayer.str, GameUtilities.centerStringX(g, onePlayer.str), onePlayer.y + onePlayer.height); // 1 player text gray
				g.drawString(back.str, GameUtilities.centerStringX(g, back.str), back.y + back.height); // back text

			} else if (mouseOver(mx, my, back.x, back.y, back.width, back.height)) { // * back mouse over condition
				g.setColor(Color.WHITE);
				g.drawString(back.str, GameUtilities.centerStringX(g, back.str), back.y + back.height); // back text

				g.setColor(new Color(31, 31, 31));

				g.drawString(onePlayer.str, GameUtilities.centerStringX(g, onePlayer.str), onePlayer.y + onePlayer.height); // 1 player text gray
				g.drawString(twoPlayer.str, GameUtilities.centerStringX(g, twoPlayer.str), twoPlayer.y + twoPlayer.height); // 2 players text gray

			} else { // * no mouse over condition

				g.setColor(new Color(31, 31, 31));

				g.drawString(onePlayer.str, GameUtilities.centerStringX(g, onePlayer.str), onePlayer.y + onePlayer.height); // 1 player text gray
				g.drawString(twoPlayer.str, GameUtilities.centerStringX(g, twoPlayer.str), twoPlayer.y + twoPlayer.height); // 2 players text gray
				g.drawString(back.str, GameUtilities.centerStringX(g, back.str), back.y + back.height); // back text

			}

			g.setFont(new Font("Aquire", Font.PLAIN, 20));
			g.drawString("Developed by Hans Duran", 30, Game.HEIGHT - 15);

		} else if (Game.gameState == Game.STATE.Pause) { // ------------------- STATE.Pause
			
			g.setFont(new Font("Aquire", Font.PLAIN, 80));
			
			int x = GameUtilities.centerStringX(g, "Paused");
			g.setColor(Color.WHITE);
			g.drawString("Paused", x, 250); // title text white
			g.setColor(new Color(31, 31, 31));
			g.drawString("Paused", x + 1, 251); // title text gray

			g.setFont(new Font("Aquire", Font.PLAIN, 60));
			fontMetrics = g.getFontMetrics();

			resume = GameUtilities.getScreenText(g, fontMetrics, "Resume", 400 + yDisplace);
			menu = GameUtilities.getScreenText(g, fontMetrics, "Quit", 500 + yDisplace);

			if (mouseOver(mx, my, resume.x, resume.y, resume.width, resume.height)) { // * resume mouse over condition
				g.setColor(Color.WHITE);
				g.drawString(resume.str, GameUtilities.centerStringX(g, resume.str), resume.y + resume.height); // resume text white

				g.setColor(new Color(31, 31, 31));

				g.drawString(menu.str, GameUtilities.centerStringX(g, menu.str), menu.y + menu.height); // quit text gray

			} else if (mouseOver(mx, my, menu.x, menu.y, menu.width, menu.height)) { // * quit mouse over condition
				g.setColor(Color.WHITE);
				g.drawString(menu.str, GameUtilities.centerStringX(g, menu.str), menu.y + menu.height); // quit text white

				g.setColor(new Color(31, 31, 31));

				g.drawString(resume.str, GameUtilities.centerStringX(g, resume.str), resume.y + resume.height); // resume text gray

			} else { // * no mouse over condition
				g.drawString(resume.str, GameUtilities.centerStringX(g, resume.str), resume.y + resume.height); // resume text gray
				g.drawString(menu.str, GameUtilities.centerStringX(g, menu.str), menu.y + menu.height); // quit text gray
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if (Game.gameState == Game.STATE.Menu) {// ------------------- STATE.Menu

			if (mouseOver(mx, my, play.x, play.y, play.width, play.height))
				Game.gameState = Game.STATE.SelectPlayer;
			else if (mouseOver(mx, my, quit.x, quit.y, quit.width, quit.height))
				System.exit(0);

		} else if (Game.gameState == Game.STATE.SelectPlayer) { // ------------------- STATE.SelectPlayer

			if (mouseOver(mx, my, onePlayer.x, onePlayer.y, onePlayer.width, onePlayer.height)) {
				loadOnePlayer();
				Game.gameState = Game.STATE.OnePlayer;
			} else if (mouseOver(mx, my, twoPlayer.x, twoPlayer.y, twoPlayer.width, twoPlayer.height)) {
				loadTwoPlayers();
				Game.gameState = Game.STATE.TwoPlayer;
			} else if (mouseOver(mx, my, back.x, back.y, back.width, back.height))
				Game.gameState = Game.STATE.Menu;

		} else if (Game.gameState == Game.STATE.Pause) { // ------------------- STATE.Pause

			if (mouseOver(mx, my, resume.x, resume.y, resume.width, resume.height))
				Game.gameState = prevState;
			else if (mouseOver(mx, my, menu.x, menu.y, menu.width, menu.height)) {
				clearGame();
				Game.gameState = Game.STATE.SelectPlayer;
			}

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	public static final boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if ((mx > x && mx < x + width) && (my > y && my < y + height))
			return true;
		return false;
	}

	private static final void loadOnePlayer() {
		Game.handler.addObject(new Player(ID.Player, 100, Game.HEIGHT / 2 - 50, 20, 100));
		Ball ball = new Ball(ID.Ball, Game.WIDTH / 2 - 13, GameUtilities.getRandomValue(0, Game.HEIGHT - 26), 26, 26);
		Game.handler.addObject(ball);
		Game.handler.addObject(new AI(ID.AI, Game.WIDTH - 100, Game.HEIGHT / 2 - 50, 20, 100, ball));
	}

	private static final void loadTwoPlayers() {
		Game.handler.addObject(new Player(ID.Player, 100, Game.HEIGHT / 2 - 50, 20, 100));
		Game.handler.addObject(new Player(ID.Player2, Game.WIDTH - 100, Game.HEIGHT / 2 - 50, 20, 100));
		Game.handler.addObject(new Ball(ID.Ball, Game.WIDTH / 2 - 13, GameUtilities.getRandomValue(0, Game.HEIGHT - 26), 26, 26));
	}

	public static final void clearGame() {
		Game.handler.object.clear();
		Score.reset();
	}
	
}
