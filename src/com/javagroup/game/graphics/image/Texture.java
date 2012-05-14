package com.javagroup.game.graphics.image;
import java.awt.image.BufferedImage;


public class Texture {

	private BufferedImage image;
	private int id;
	
	public Texture(int id) {
		image = Art.getTileSheet().getCell(id);
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
