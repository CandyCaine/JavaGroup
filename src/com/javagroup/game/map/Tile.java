package com.javagroup.game.map;

import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.graphics.image.Texture;

public class Tile {

	protected float x;
	protected float y;
	protected int id;
	private Texture texture;
	
	public Tile(int id, float x, float y) {
		this.id = id;
		this.x = x;
		this.y = y;
		texture = Art.getTextureByID(id);
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setLocation(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public int getID() {
		return id;
	}
	
	public Texture getTexture() {
		return texture;
	}
}
