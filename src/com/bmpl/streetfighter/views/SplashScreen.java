package com.bmpl.streetfighter.views;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.bmpl.streetfighter.utils.GameConstants;

import jaco.mp3.player.MP3Player;

public class SplashScreen extends JFrame implements GameConstants {
	
	private JLabel label = new JLabel();
	
	public SplashScreen() {
		setTitle(TITLE);
		setSize(SCREENWIDTH, SCREENHEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Icon icon = new ImageIcon(SplashScreen.class.getResource(SPLASH_BG));
		label.setIcon(icon);
		this.add(label);
		loadMusic();
		setVisible(true);
		
		try {
			Thread.sleep(10000);
			setVisible(false);
			dispose();
			GameScreen gs = new GameScreen();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void loadMusic() {
		new MP3Player(SplashScreen.class.getResource("bg_theme.mp3")).play();
	}

	public static void main(String[] args) {
		SplashScreen screen = new SplashScreen();

	}

}
