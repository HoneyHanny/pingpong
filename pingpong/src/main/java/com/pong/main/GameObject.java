package com.pong.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected ID id;
	protected int x, y;
	protected int velX, velY;
	protected int width, height;

	public GameObject(ID id, int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.width = width;
		this.height = height;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ID getId() {
		return this.id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public int getVelX() {
		return this.velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return this.velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

}
