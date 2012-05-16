package com.javagroup.game.world;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public class Chunk {
	public static final int size = 24;
	
	private Coordinate coordinate;
	
	private Map<Coordinate, Tile> tiles;
	
	public Chunk(int x, int y) {
		tiles = new HashMap<Coordinate, Tile>();
		coordinate = new Coordinate(x, y);
		addTiles();
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public void addTiles() {
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				Coordinate c = new Coordinate(coordinate.getX() + x, coordinate.getY() + y);
				tiles.put(c, new Tile(0, c));
			}
		}
	}
	
	public Tile getTileAt(int x, int y) {
		for (Coordinate coordinate : tiles.keySet()) {
			if (coordinate.getX() == x && coordinate.getY() == y) {
				return tiles.get(coordinate);
			}
		}
		return null;
	}
	
	public void render(Graphics g) {
		for (Tile tile : tiles.values()) {
			tile.render(g);
		}
	}
}
