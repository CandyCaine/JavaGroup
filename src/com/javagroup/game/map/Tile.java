package com.javagroup.game.map;

import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.graphics.image.Texture;

public class Tile {

	public static enum TileType {
		Grass		(0),
		Rock		(1),
		Rocks		(2),
		Pond		(3),
		Mushroom	(4);
		
		private int id;
		TileType(int id) {
			this.id = id;
		}
		
		public int getID() {
			return id;
		}
	}
	
	protected float x;
	protected float y;
	protected int id;
	private Texture texture;
	private TileType type;
	
	public Tile(int id, float x, float y) {
		this.id = id;
		this.x = x;
		this.y = y;
		texture = Art.getTextureByID(id);
	}
	
	public void setID(int id) {
		this.id = id;
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
