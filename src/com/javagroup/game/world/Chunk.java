package com.javagroup.game.world;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.javagroup.game.graphics.BasicGame;
import com.javagroup.game.map.camera.Camera;

public class Chunk {
	public static final int size = 24;
	public static final int pixelSize = 24 * 32;

	private World world;

	private Coordinate coordinate;

	private Map<Coordinate, Tile> tiles;

	private Biome biome;
	private boolean biomeSet = false;

	public Chunk(int x, int y, World world) {
		tiles = new HashMap<Coordinate, Tile>();
		coordinate = new Coordinate(x, y);
		this.world = world;
		addTiles();
	}

	public Chunk(int x, int y, Biome biome, World world) {
		tiles = new HashMap<Coordinate, Tile>();
		coordinate = new Coordinate(x, y);
		this.biome = biome;
		biomeSet = true;
		this.world = world;
		addTiles();
		generateRandomTiles();
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

	public void generateRandomTiles() {
		Random r = world.getRandom();
		int max = biome.getAvailableTiles().length;
		for (Map.Entry<Coordinate, Tile> entry : tiles.entrySet()) {
			entry.getValue().setTile(biome.getAvailableTiles()[r.nextInt(max)]);
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
