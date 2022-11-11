package com.pong.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

	private int p1Vel[] = new int[2];
	private int p2Vel[] = new int[2];
	public static int playerSpeed = 7;

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_BACK_SLASH)
			if (Game.fps) Game.fps = false;
			else Game.fps = true; 

		if (Game.gameState == Game.STATE.OnePlayer) { // ------------------- STATE.OnePlayer
			for (GameObject tempObject : Game.handler.object) {
				if (tempObject.getId() == ID.Player) {
					if(key == KeyEvent.VK_W) p1Vel[0] = -playerSpeed;
					if(key == KeyEvent.VK_S) p1Vel[1] = playerSpeed;
					tempObject.setVelY(p1Vel[0] + p1Vel[1]);
				}
			}
			if (key == KeyEvent.VK_ESCAPE) {
				Menu.prevState = Game.STATE.OnePlayer;
				Game.gameState = Game.STATE.Pause;
			}
			
		} else if (Game.gameState == Game.STATE.TwoPlayer) { // ------------------- STATE.TwoPlayer
			for (GameObject tempObject : Game.handler.object) {
				if (tempObject.getId() == ID.Player) {
					if (key == KeyEvent.VK_W)
						p1Vel[0] = -playerSpeed;
					if (key == KeyEvent.VK_S)
						p1Vel[1] = playerSpeed;
					tempObject.setVelY(p1Vel[0] + p1Vel[1]);
				}
			}
			for (GameObject tempObject : Game.handler.object) {
				if (tempObject.getId() == ID.Player2) {
					if(key == KeyEvent.VK_UP) p2Vel[0] = -playerSpeed;
					if(key == KeyEvent.VK_DOWN) p2Vel[1] = playerSpeed;
					tempObject.setVelY(p2Vel[0] + p2Vel[1]);
				}
			}
			if (key == KeyEvent.VK_ESCAPE) {
				Menu.prevState = Game.STATE.TwoPlayer;
				Game.gameState = Game.STATE.Pause;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (GameObject tempObject : Game.handler.object) {
			if (tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_W) p1Vel[0] = 0;
				if(key == KeyEvent.VK_S) p1Vel[1] = 0;
				tempObject.setVelY(p1Vel[0] + p1Vel[1]);
			}
		}

		for (GameObject tempObject : Game.handler.object) {
			if (tempObject.getId() == ID.Player2) {
				if(key == KeyEvent.VK_UP) p2Vel[0] = 0;
				if(key == KeyEvent.VK_DOWN) p2Vel[1] = 0;
				tempObject.setVelY(p2Vel[0] + p2Vel[1]);
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
