package com.javagroup.game.map;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


public class Map {

	private String name;
	private ArrayList<Tile> tiles;
	private int width;
	private int height;
	private final int tileSize = 32;
	private Random r = new Random();
	
	public Map(String name, int width, int height) {
		this.name = name;
		tiles = new ArrayList<Tile>();
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
				tiles.add(new Tile(r.nextInt(4), (x * tileSize), y * tileSize));
			}
		}
	}
	
	public void render(Graphics g, float xOffset, float yOffset) {
		for (int i = 0; i < tiles.size(); i++) {
			g.drawImage(tiles.get(i).getTexture().getImage(), (int)(xOffset + tiles.get(i).getX()), (int)(yOffset + tiles.get(i).getY()), tileSize, tileSize, null);
		}
	}
}
