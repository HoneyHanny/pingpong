package com.pong.main;

import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject {

	public Player(ID id, int x, int y, int width, int height) {
		super(id, x, y, width, height);
	}

	@Override
	public void tick() {
		y += velY;
		y = GameUtilities.clamp(y, 0, Game.HEIGHT - height);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}
	
}
