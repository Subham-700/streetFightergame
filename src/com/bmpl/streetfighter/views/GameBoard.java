package com.bmpl.streetfighter.views;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.bmpl.streetfighter.sprites.Hulk;
import com.bmpl.streetfighter.sprites.PlayerHealth;
import com.bmpl.streetfighter.sprites.Thor;
import com.bmpl.streetfighter.utils.GameConstants;

public class GameBoard extends JPanel implements GameConstants {
	BufferedImage bgImage;
	private Hulk hulk;
	private Thor thor;
	private Timer timer;
	private PlayerHealth hulkHealth;
	private PlayerHealth thorHealth;
	public GameBoard() {
		hulk = new Hulk();
		thor = new Thor();
		setFocusable(true);
		loadBackground();
		keyEvents();
		showHealth();
		gameLoop();
	}
	
	private void gameLoop() {
		timer = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				collision();
				repaint();
			}
		});
		timer.start();
	}
	
	private void showHealth() {
		hulkHealth = new PlayerHealth("Hulk",10);
		thorHealth = new PlayerHealth("Thor",SCREENWIDTH - 860);
	}
	
	private void printHealth(Graphics pen) {
		hulkHealth.showHealthBar(pen);
		thorHealth.showHealthBar(pen);
	}
	
	private boolean isCollide() {
		int xDist = Math.abs(hulk.getX() - thor.getX());
		int yDist = Math.abs(hulk.getY() - thor.getY());
		int maxH = Math.max(hulk.getH(), thor.getH());
		int maxW = Math.max(hulk.getW(), thor.getW());
		return xDist <= maxW && yDist <= maxH;
	}
	
	private void collision() {
		if(isCollide()) {
			if(hulk.isAttack()) {
				thor.setCurrentMove(HIT);
				thorHealth.damage += 10;
			}
			hulk.setCollision(true);
		}
		else {
			
		}
	}
	
	private void keyEvents() {
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
//				System.out.println("Key Typed : " + e.getKeyCode());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
//				System.out.println("Key Released : " + e.getKeyCode());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println("Key Pressed : " + e.getKeyCode());
				// Hulk Movement
				if(e.getKeyCode() == KeyEvent.VK_D) {
					hulk.setAttack(false);
					hulk.setSpeed(SPEED);
					hulk.movePlayer();
					hulk.setCurrentMove(WALK);
					//repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_A) {
					hulk.setAttack(false);
					hulk.setCollision(false);
					hulk.setSpeed(-SPEED);
					hulk.movePlayer();
					hulk.setCurrentMove(WALK);
					//repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_Z) {
					hulk.setAttack(true);
					hulk.setCurrentMove(PUNCH);
					//repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_X) {
					hulk.setAttack(true);
					hulk.setCurrentMove(SECONDARY_PUNCH);
					//repaint();
				}
				
				// Thor Movement
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					thor.setSpeed(SPEED);
					thor.movePlayer();
					//repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					thor.setSpeed(-SPEED);
					thor.movePlayer();
					//repaint();
				}
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics pen) {
		paintBackground(pen);
		hulk.defaultImage(pen);
		thor.defaultImage(pen);
		printHealth(pen);
	}
	
	private void paintBackground(Graphics pen) {
		pen.drawImage(bgImage, 0, 0, SCREENWIDTH, SCREENHEIGHT, null);
	}
	
	private void loadBackground() {
		try {
			bgImage = ImageIO.read(GameBoard.class.getResource("bg_1.jpg"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Something went wrong...");
			System.out.println("Failed to load background image...");
			System.exit(0);
			
		}
	}
}
