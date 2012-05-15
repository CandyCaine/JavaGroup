package com.javagroup.game.map;
import java.awt.Graphics;
import java.util.Random;


public class Map {

	public static final float tileSize = 32;
	public static final float chunkSize = 16;
	
	private String name;
	private Tile[][] tiles;
	private int width;
	private int height;
	private Random r = new Random();
	
	public Map(String name, int width, int height) {
		this.name = name;
		tiles = new Tile[width][height];
		this.width = width;
		this.height = height;
		loadTiles();
	}
	
	public String getName() {
		return name;
	}
	
	public void loadTiles() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = new Tile(r.nextInt(5), x * tileSize, y * tileSize);
			}
		}
		
		determineTileType();
	}
	
	public void determineTileType() {
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Tile t = tiles[x][y];
				
			}
		}
	}
	
	public void render(Graphics g, float xOffset, float yOffset) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				g.drawImage(tiles[x][y].getTexture().getImage(), (int)(xOffset + tiles[x][y].getX()), (int)(yOffset + tiles[x][y].getY()), (int)tileSize, (int)tileSize, null);
			}
		}
	}
}
