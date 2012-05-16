package com.javagroup.game.world;

import java.awt.Graphics;

public class World {

	private int width;
	private int height;
	
	private ChunkList chunkList;
	
	public World(int width, int height) {
		this.width = width;
		this.height = height;
		chunkList = new ChunkList();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Tile getTileAt(int x, int y) {
		for (int i = 0; i < chunkList.size(); i++) {
			Coordinate c = chunkList.getList().get(i).getCoordinate();
			if (x > c.getX() && x < c.getX() + Chunk.size) {
				if (y > c.getY() && y < c.getY() + Chunk.size) {
					return chunkList.getList().get(i).getTileAt(x, y);
				}
			}
		}
		return null;
	}
	
	public Tile getCurrentTile() {
		return null;
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < chunkList.size(); i++) {
			chunkList.getList().get(i).render(g);
		}
	}
}
