package com.bmpl.streetfighter.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.bmpl.streetfighter.utils.GameConstants;

public class Hulk extends CommonPlayer implements GameConstants {
	
	private BufferedImage idleFrames[] = new BufferedImage[6];
	private BufferedImage walkFrames[] = new BufferedImage[6];
	private BufferedImage punchFrames[] = new BufferedImage[6];
	private BufferedImage secondaryPunchFrames[] = new BufferedImage[4];
	
	public Hulk() {
		x = 200;
		h = 350;
		w = 300;
		y = GROUND - h;
		speed = SPEED;
		imageIndex = 0;
		loadPlayerImage();
		loadIdleImage();
		loadWalkImages();
		loadPunchImages();
		loadSecondaryPunchImages();
	}
	
	private void loadIdleImage() {
		idleFrames[0] = img.getSubimage(35, 36, 60, 86);
		idleFrames[1] = img.getSubimage(422, 167, 55, 84);
		idleFrames[2] = img.getSubimage(552, 167, 59, 84);
		idleFrames[3] = img.getSubimage(677, 181, 57, 70);
		idleFrames[4] = img.getSubimage(803, 181, 58, 70);
		idleFrames[5] = img.getSubimage(934, 171, 58, 80);	
	}
	
	private void loadWalkImages() {
		walkFrames[0] = img.getSubimage(144, 36, 89, 86);
		walkFrames[1] = img.getSubimage(299, 36, 53, 86);
		walkFrames[2] = img.getSubimage(421, 36, 56, 86);
		walkFrames[3] = img.getSubimage(534, 36, 91, 86);
		walkFrames[4] = img.getSubimage(665, 36, 89, 86);
		walkFrames[5] = img.getSubimage(810, 36, 52, 86);
	}
	
	private void loadPunchImages() {
		punchFrames[0] = img.getSubimage(25, 527, 69, 107);
		punchFrames[1] = img.getSubimage(153, 527, 69, 107);
		punchFrames[2] = img.getSubimage(283, 527, 63, 107);
		punchFrames[3] = img.getSubimage(411, 531, 96, 103);
		punchFrames[4] = img.getSubimage(538, 568, 98, 66);
		punchFrames[5] = img.getSubimage(669, 568, 88, 66);
	}
	
	private void loadSecondaryPunchImages() {
		secondaryPunchFrames[0] = img.getSubimage(536, 1841, 82, 73);
		secondaryPunchFrames[1] = img.getSubimage(671, 1841, 95, 73);
		secondaryPunchFrames[2] = img.getSubimage(798, 1841, 97, 73);
		secondaryPunchFrames[3] = img.getSubimage(918, 1841, 79, 73);
	}
	
	private BufferedImage showWalk() {
		isAttack = false;
		if(imageIndex > walkFrames.length-1) {
			imageIndex = 0;
			currentMove = IDLE;
		}
		BufferedImage img = walkFrames[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage showIdle() {
		isAttack = false;
		if(imageIndex > idleFrames.length-1) {
			imageIndex = 0;
		}
		BufferedImage img = idleFrames[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage showPunch() {
		isAttack = true;
		if(imageIndex > punchFrames.length-1) {
			imageIndex = 0;
			currentMove = IDLE;
		}
		BufferedImage img = punchFrames[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage showSecondaryPunch() {
		isAttack = true;
		if(imageIndex > secondaryPunchFrames.length-1) {
			imageIndex = 0;
			currentMove = IDLE;
		}
		BufferedImage img = secondaryPunchFrames[imageIndex];
		imageIndex++;
		return img;
	}
	
	@Override
	public BufferedImage defaultImage() {
		if(currentMove == WALK) {
			return showWalk();
		}
		else if(currentMove == PUNCH) {
			return showPunch();
		}
		else if(currentMove == SECONDARY_PUNCH) {
			return showSecondaryPunch();
		}
		else {
			return showIdle();
		}
	}
	
	
	private void loadPlayerImage() {
		try {
			img = ImageIO.read(Hulk.class.getResource(HULK_IMG));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
