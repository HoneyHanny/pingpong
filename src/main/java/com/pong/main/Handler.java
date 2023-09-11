package com.pong.main;

import java.awt.Graphics;

import java.util.LinkedList;

public class Handler {
	
	public LinkedList<GameObject> object = new LinkedList<GameObject>();

	public void tick() {
		for (GameObject gameObject : object) {
			gameObject.tick();
		}
	}

	public void render(Graphics g) {
		for (GameObject gameObject : object) {
			gameObject.render(g);
		}
	}

	public void addObject(GameObject object) {
		this.object.add(object);
	}

	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

	// public void clearEnemies() {
	// for (int i = 0; i < object.size(); i++) {
	// GameObject tempObject = object.get(i);
	// if (tempObject.getId() != ID.Player && tempObject.getId() !=
	// ID.EnemyBossBullet) {
	// removeObject(tempObject);
	// i--;
	// }
	// }
	// }

	public void clearPlayer() {
		object.removeIf(x -> x.getId() == ID.Player); // java 1.8 and higher only
		// for (int i = 0; i < object.size(); i++) {
		// 	GameObject tempObject = object.get(i);
		// 	if (tempObject.getId() == ID.Player) {
		// 		removeObject(tempObject);
		// 		i--;
		// 	}
		// }
	}

	// public void clearEnemiesAndBullets() {
		// object.removeIf(x -> x.getId() != ID.Player); // java 1.8 and higher only
	// 	for (int i = 0; i < object.size(); i++) {
	// 		GameObject tempObject = object.get(i);
	// 		if (tempObject.getId() == ID.Obstacle) {
	// 			removeObject(tempObject);
	// 			i--;
	// 		}
	// 	}
	// }

	// public void clearBoss() {
	// object.removeIf(x -> x.getId() == ID.EnemyBoss);
	// }
	
}
