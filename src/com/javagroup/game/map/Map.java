package com.javagroup.game.map;
import java.awt.Graphics;
import java.util.Random;

import com.javagroup.game.graphics.BasicGame;
import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.map.Tile.TileType;
import com.javagroup.game.map.camera.Camera;


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
		
		
		int setUnCol = 2;
		boolean looped = false;
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				
				
			
				
				if(setUnCol != 0){
					
					setUnCol -= 1;
					
					int R = r.nextInt(2);
					
					if(R == 1){
					tiles[y][x] = new Tile(0, x*tileSize, y*tileSize);
			
					looped = true;
					}
					if(R == 0){
					tiles[y][x] = new Tile(4, x*tileSize, y*tileSize);
					
					looped = true;
					}
				}
				if(setUnCol == 0){
					looped = true;
				
					tiles[y][x] = new Tile(r.nextInt(3)+1, x*tileSize, y*tileSize);
					
					looped = true;
					
					if(r.nextInt(2) == 0){
					if(tiles[y][x].getID() < 4 && r.nextInt(20) < 15){
						looped = true;
						
										
						setUnCol += r.nextInt(10);
					}
					}else{
						
						if(tiles[y][x].getID() < 4 && r.nextInt(20) >= 10){
							looped = true;
							setUnCol += r.nextInt(20) + 1;
						}
						
					}
				}
				TileType these = tiles[y][x].getTileType();
				if(these != null){
					//detect collideable here....but won't do anything for now.
				}
				
					//tiles[x][y] = new Tile(r.nextInt(5), x * tileSize, y * tileSize);
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
	
	public void render(Graphics g) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if(Math.round(tiles[x][y].getY()+Camera.getCamera().getYOff()+Art.getTileSheet().getCellSize()) < 0 || tiles[x][y].getY()+Camera.getCamera().getYOff() > BasicGame.size.height)
					continue;
				else if(tiles[x][y].getX()+Camera.getCamera().getXOff()+Art.getTileSheet().getCellSize() < 0 || tiles[x][y].getX()+Camera.getCamera().getXOff() > BasicGame.size.width)
					continue;
				g.drawImage(tiles[x][y].getTexture().getImage(), Math.round(Camera.getCamera().getXOff()) + (int)tiles[x][y].getX(), Math.round(Camera.getCamera().getYOff()) + (int)tiles[x][y].getY(), (int)tileSize, (int)tileSize, null);
			}
		}
		
	}
	
}
