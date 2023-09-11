package com.pong.main;

import java.awt.Graphics;

public class Ball extends GameObject {

	private int velocity = 8;
	private int tick = 0;
	private int bounceTick = 0;
	private boolean bounced = false;

	public Ball(ID id, int x, int y, int width, int height) {
		super(id, x, y, width, height);

		switch (GameUtilities.getRandomValue(0, 3)) {
			case 0:
				this.velY = -this.velocity;
				this.velX = -this.velocity;
				break;

			case 1:
				this.velY = this.velocity;
				this.velX = -this.velocity;
				break;

			case 2:
				this.velY = -this.velocity;
				this.velX = this.velocity;
				break;

			case 3:
				this.velY = this.velocity;
				this.velX = this.velocity;
				break;
		}

	}

	@Override
	public void tick() {
		this.x += this.velX;
		this.y += this.velY;

		if (this.y <= 0 || this.y >= Game.HEIGHT - height) velY *= -1;

		if (this.bounced){
			this.bounceTick++;
			if (this.bounceTick == 60) {
				this.bounceTick = 0;
				this.bounced = false;
			}
		}
		collision();

		// * check if a player has scored
		if (this.x <= -width || this.x >= Game.WIDTH) {

			Game.scored = true;
			if (Game.scored) this.tick++;

			if (this.tick > 60) {

				if (x <= -width) Game.rscored = true; // check if player 1 or player 2 scored
				else Game.lscored = true;

				this.tick = 0;
				Game.scored = false;

				this.x = Game.WIDTH / 2 - 25; // spawn ball in the middle of the screen (X)

				// spawn ball in middle in a 100 height (Y)
				/* 
					*screen
					+------------------------------------------+
					|                     |                    |
					|                     |                    |
					|                    ---                   |
					|                     |                    |
					|                     |                    |
					|                    ---                   |
					|                     |                    |
					|                     |                    |
					+------------------------------------------+
				*/
				int p1 = GameUtilities.centerLengthY(100);
				this.y = GameUtilities.getRandomValue(p1, p1 + 100);

				switch (GameUtilities.getRandomValue(0, 1)) {
					case 0: // going down
						this.velY = this.velocity;
						break;
					case 1: // going up
						this.velY = -this.velocity;
						break;
				}


				if (Game.lscored) this.velX = -this.velocity;
				else this.velX = this.velocity;

			}

		}

	}

	@Override
	public void render(Graphics g) {
		g.setColor(java.awt.Color.WHITE);
		g.fillOval(this.x, this.y, this.width, this.height);
	}

	private void collision() {
		for (GameObject tempObject : Game.handler.object)
			if (tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2 || tempObject.getId() == ID.AI)
				if (getBounds().intersects(tempObject.getBounds()) && bounced == false) {
					this.velY *= -1;
					this.velX *= -1;
					if (tempObject.getVelY() > 0) this.velY++;
					else if (tempObject.getVelY() < 0) this.velY--;
					else {
						if (this.velY > 0) this.velY = this.velocity;
						else if (this.velY < 0) this.velY = -this.velocity;
					}
					this.bounced = true;
				}
	}
}
