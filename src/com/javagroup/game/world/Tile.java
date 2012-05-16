package com.javagroup.game.world;

import java.awt.Graphics;

import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.graphics.image.Texture;
import com.javagroup.game.map.camera.Camera;

public class Tile {
	public static final int tileSize = 32;
	
	private Coordinate coordinate;
	private int id;
	
	private Texture texture;

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

	public Tile(int id, int x, int y) {
		this.id = id;
		coordinate = new Coordinate(x, y);
		texture = Art.getTextureByID(id);
	}
	
	public Tile(int id, Coordinate coordinate) {
		this.id = id;
		this.coordinate = coordinate;
		texture = Art.getTextureByID(id);
	}
	
	public int getID() {
		return id;
	}
	
	public Coordinate getCoordinates() {
		return coordinate;
	}
	
	public void render(Graphics g) {
		g.drawImage(texture.getImage(), Math.round((coordinate.getX() + Camera.getCamera().getXOff())), Math.round((coordinate.getX() + Camera.getCamera().getYOff())), null);
	}
}
