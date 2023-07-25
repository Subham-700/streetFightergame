package com.bmpl.streetfighter.views;

import javax.swing.JFrame;

import com.bmpl.streetfighter.utils.GameConstants;

public class GameScreen extends JFrame implements GameConstants {
	
	public GameScreen() {
		// set title of game window
		setTitle(TITLE);
		// set width and height of game screen
		setSize(SCREENWIDTH, SCREENHEIGHT);
		// so now we cannot resize our game screen
		setResizable(false);
		// used to set window in center
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GameBoard board = new GameBoard();
		add(board);
		
		// used to show screen
		setVisible(true);
	}

//	public static void main(String[] args) {
//		GameScreen obj = new GameScreen();
//	}

}
