package com.pong.main;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.FontMetrics;

// Utility methods for the game
public final class GameUtilities {

	public static final int changeScale(int left, int right, int value) {
		return value * left / right;
	}

	public static final float changeScale(float left, float right, float value) {
		return value * left / right;
	}

	public static final int clamp(int val, int min, int max) {
		return Math.max(min, Math.min(max, val));
	}

	public static final float clamp(float val, float min, float max) {
		if (val >= max) return max;
		else if (val <= min) return min;
		else return val;
	}

	public static final boolean isDivisibleBy(int divisible, int value) {
		return value % divisible == 0 ? true : false;
	}

	public static final int getRandomValue(int min, int max) {
		return java.util.concurrent.ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	public static final int getRandomValue() {
		return new java.util.Random().nextInt();
	}

	public static final void DisplayFramesPerSecond(Graphics g, Font font) throws NullPointerException {
		if (Game.fps) {
			g.setColor(Color.GREEN);
			g.setFont(font);
			if (Game.ticks == 20) {
				Game.ticks = 0;
				g.drawString(Game.frames + "", Game.WIDTH - g.getFontMetrics().stringWidth(Game.frames + "") - 5, 14);
			} else
				g.drawString(Game.prevframes + "",
						Game.WIDTH - g.getFontMetrics().stringWidth(Game.prevframes + "") - 5, 14);
		}
	}

	public static final void DisplayFramesPerSecond(Graphics g, Font font, Color color) throws NullPointerException {
		if (Game.fps) {
			g.setColor(color);
			g.setFont(font);
			if (Game.ticks == 20) {
				Game.ticks = 0;
				g.drawString(Game.frames + "", Game.WIDTH - g.getFontMetrics().stringWidth(Game.frames + "") - 5, 14);
			} else
				g.drawString(Game.prevframes + "",
						Game.WIDTH - g.getFontMetrics().stringWidth(Game.prevframes + "") - 5, 14);
		}
	}

	public static final void DisplayFramesPerSecond(Graphics g, String fontName, int fontStyle, int fontSize) 
			throws NullPointerException {
		if (Game.fps) {
			g.setColor(Color.GREEN);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			if (Game.ticks == 20) {
				Game.ticks = 0;
				g.drawString(Game.frames + "", Game.WIDTH - g.getFontMetrics().stringWidth(Game.frames + "") - 5, 14);
			} else
				g.drawString(Game.prevframes + "",
						Game.WIDTH - g.getFontMetrics().stringWidth(Game.prevframes + "") - 5, 14);
		}
	}

	public static final void DisplayFramesPerSecond(Graphics g, String fontName, int fontStyle, int fontSize, Color color) 
			throws NullPointerException {
		if (Game.fps) {
			g.setColor(color);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			if (Game.ticks == 20) {
				Game.ticks = 0;
				g.drawString(Game.frames + "", Game.WIDTH - g.getFontMetrics().stringWidth(Game.frames + "") - 5, 14);
			} else
				g.drawString(Game.prevframes + "",
						Game.WIDTH - g.getFontMetrics().stringWidth(Game.prevframes + "") - 5, 14);
		}
	}

	public static final void DisplayFramesPerSecond(Graphics g) throws NullPointerException {
		if (Game.fps) {
			g.setColor(Color.GREEN);
			g.setFont(new Font("monospaced", Font.PLAIN, 14));
			if (Game.ticks == 20) {
				Game.ticks = 0;
				g.drawString(Game.frames + "", Game.WIDTH - g.getFontMetrics().stringWidth(Game.frames + "") - 5, 14);
			} else
				g.drawString(Game.prevframes + "", Game.WIDTH - g.getFontMetrics().stringWidth(Game.prevframes + "") - 5, 14);
		}
	}

	public static final void DisplayFramesPerSecond(Graphics g, Color color) throws NullPointerException {
		if (Game.fps) {
			g.setColor(color);
			g.setFont(new Font("monospaced", Font.PLAIN, 14));
			if (Game.ticks == 20) {
				Game.ticks = 0;
				g.drawString(Game.frames + "", Game.WIDTH - g.getFontMetrics().stringWidth(Game.frames + "") - 5, 14);
			} else
				g.drawString(Game.prevframes + "",
						Game.WIDTH - g.getFontMetrics().stringWidth(Game.prevframes + "") - 5, 14);
		}
	}

	public static final void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2) throws NullPointerException {
		Graphics2D g2d = (Graphics2D) g.create();
		BasicStroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 15 }, 0);
		g2d.setStroke(dashed);
		g2d.drawLine(x1, y1, x2, y2);
		g2d.dispose();
	}

	public static final int centerStringX(Graphics g, String str) throws NullPointerException {
		return (Game.WIDTH - g.getFontMetrics().stringWidth(str)) / 2;
	}

	public static final int centerLengthX(int width) {
		return (Game.WIDTH - width) / 2;
	}

	public static final int centerLengthY(int height) {
		return (Game.HEIGHT - height) / 2;
	}

	public static final int centerLength(int distance, int length) {
		return (distance - length) / 2;
	}

	public static final Rectangle getRectangleStringMetrics(Graphics g, FontMetrics fm, String str, int y) throws NullPointerException {
		return new Rectangle(centerStringX(g, str), y - fm.getHeight(), fm.stringWidth(str), fm.getHeight());
	}

	public static final ScreenText getScreenText(Graphics g, FontMetrics fm, String str, int y) throws NullPointerException {
		return new ScreenText(str, centerStringX(g, str), y - fm.getHeight(), fm.stringWidth(str), fm.getHeight());
	}

	public static final int getInnerCenterPosition(int p1, int p2, int length) {
		if (p1 > p2)
			return (((p1 - p2) - length) / 2) + p2;
		else if (p2 > p1)
			return (((p2 - p1) - length) / 2) + p1;
		return 0;
	}

}
