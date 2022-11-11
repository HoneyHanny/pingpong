package com.pong.main;

import java.awt.Color;
import java.awt.Graphics;

public class AI extends GameObject {

	private Ball ball;

	public AI(ID id, int x, int y, int width, int height, Ball ball) {
		super(id, x, y, width, height);
		this.ball = ball;
	}

	@Override
	public void tick() {
		int ballY = ball.getY();
		if (ballY > y + height / 2) velY = KeyInput.playerSpeed;
		else if (ballY < y && ballY > y + height / 2) velY = 0;
		else velY = -KeyInput.playerSpeed;
		y += velY;
		y = GameUtilities.clamp(y, 0, Game.HEIGHT - height);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}
	
}
