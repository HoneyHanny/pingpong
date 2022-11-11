package com.pong.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Score {

	public static int lscore = 0;
	public static int rscore = 0;

	public void tick() {
		if (Game.lscored) {
			lscore++;
			Game.lscored = false;
		} else if (Game.rscored) {
			rscore++;
			Game.rscored = false;
		}
	}

	public void render(Graphics g) {
		g.setFont(new Font("Aquire", Font.PLAIN, 30));

		g.setColor(Color.WHITE);
		g.drawString(lscore + "", Game.WIDTH / 4 - g.getFontMetrics().stringWidth(lscore + "") / 2, 35);
		g.drawString(rscore + "", (int)(Game.WIDTH * .75f - g.getFontMetrics().stringWidth(rscore + "") / 2), 35);
		
		g.setColor(Color.GRAY);
		g.drawString(lscore + "", (Game.WIDTH / 4 - g.getFontMetrics().stringWidth(lscore + "") / 2) + 1, 35 + 1);
		g.drawString(rscore + "", (int)(Game.WIDTH * .75f - g.getFontMetrics().stringWidth(rscore + "") / 2) + 1, 35 + 1);
		
	}

	public static void reset() {
		Game.lscored = false;
		Game.rscored = false;
		lscore = 0;
		rscore = 0;
	}

}
