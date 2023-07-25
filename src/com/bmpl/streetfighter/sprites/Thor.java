package com.bmpl.streetfighter.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.bmpl.streetfighter.utils.GameConstants;

public class Thor extends CommonPlayer implements GameConstants {
	
	private BufferedImage idleFrames[] = new BufferedImage[6];
	private BufferedImage hitFrames[] = new BufferedImage[4];
//	private BufferedImage walkFrames[] = new BufferedImage[6];
	
	public Thor() {
		x = SCREENWIDTH - 500;
		h = 350;
		w = 300;
		y = GROUND - h;
		speed = SPEED;
		loadPlayerImage();
		loadIdleImage();
		loadHitImage();
	}
	
	private void loadIdleImage() {
		idleFrames[0] = img.getSubimage(3397, 61, 144, 134);
		idleFrames[1] = img.getSubimage(3254, 61, 144, 134);
		idleFrames[2] = img.getSubimage(3104, 61, 148, 134);
		idleFrames[3] = img.getSubimage(2773, 61, 170, 134);
		idleFrames[4] = img.getSubimage(2599, 61, 174, 134);
		idleFrames[5] = img.getSubimage(2450, 61, 149, 134);
	}
	
	private void loadHitImage() {
		hitFrames[0] = img.getSubimage(1022, 5405, 141, 120);
		hitFrames[1] = img.getSubimage(1162, 5405, 143, 120);
		hitFrames[2] = img.getSubimage(1302, 5405, 139, 120);
		hitFrames[3] = img.getSubimage(1445, 5405, 137, 120);
	}
	
	private BufferedImage showIdle() {
		if(imageIndex > idleFrames.length-1) {
			imageIndex = 0;
		}
		BufferedImage img = idleFrames[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage showHit() {
		if(imageIndex > hitFrames.length-1) {
			imageIndex = 0;
			currentMove = IDLE;
		}
		BufferedImage img = hitFrames[imageIndex];
		imageIndex++;
		return img;
	}
	
	
	@Override
	public BufferedImage defaultImage() {
		if(currentMove == HIT) {
			return showHit();
		}
		else {
			return showIdle();
		}
	}
	
	
	private void loadPlayerImage() {
		try {
			img = ImageIO.read(Thor.class.getResource(THOR_IMG));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
