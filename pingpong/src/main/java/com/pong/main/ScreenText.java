package com.pong.main;

import java.awt.Point;
import java.awt.Rectangle;

public class ScreenText {

	public String str;
	public int x;
	public int y;
	public int width;
	public int height;
	
	public ScreenText(String str, int x, int y, int width, int height) {
		this.str = str;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public ScreenText(String str, Point point, int width, int height) {
		this(str, point.x, point.y, width, height);
	}

	public ScreenText(String str, Rectangle rect) {
		this(str, rect.x, rect.y, rect.width, rect.height);
	}
	
}
