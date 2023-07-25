package com.bmpl.streetfighter.sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PlayerHealth extends CommonPlayer {
	int x;
	int y;
	int w;
	int h;
	public int damage;
	String name;
	public PlayerHealth(String name, int x) {
		this.x = x;
		y = 10;
		w = 800;
		h = 50;
		damage = 0;
		this.name = name;
	}
	
	
	public void showHealthBar(Graphics pen) {
		pen.setColor(Color.GREEN);
		pen.fillRect(x, y, w, h);
		pen.setColor(Color.RED);
		pen.fillRect(x, y, damage, h);
		pen.setColor(Color.WHITE);
		pen.setFont(new Font("Arial", Font.BOLD, 60));
		pen.drawString(name, x, 130);
	}

	@Override
	public BufferedImage defaultImage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
