package com.pong.main;

import javax.swing.JFrame;

public class Window {

	public Window(Game game, String title) {
		JFrame frame = new JFrame();

		frame.setTitle(title);
		frame.add(game);
		frame.setUndecorated(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
		
	}
	
}
