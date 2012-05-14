package com.javagroup.game.map;
import java.awt.Graphics;
import java.util.ArrayList;


public class Map {

	private String name;
	private ArrayList<Tile> tiles;
	private int width;
	private int height;
	
	public Map(String name, int width, int height) {
		this.name = name;
		tiles = new ArrayList<Tile>();
		this.width = width;
		this.height = height;
	}
	
	public String getName() {
		return name;
	}
	
	public void loadTiles() {
		
	}
	
	public void render(Graphics g, float xOffset, float yOffset) {
		for (int i = 0; i < tiles.size(); i++) {
			
		}
	}
}
