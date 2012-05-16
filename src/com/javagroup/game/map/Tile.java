package com.javagroup.game.map;

import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.graphics.image.Texture;

public class Tile {

	public static enum TileType{
		
		Rock		(1, true),
		Rocks		(2, true),
		Pond		(3, false),
		Mushroom	(4, false),
		Grass		(5, false);
		
		private int id;
		private boolean collidable;
		TileType(int id, boolean collidable) {
			System.out.println("id");
			this.id = id;
			this.collidable = collidable;
			
		}
		
		public int getID() {
			return id;
		}
		
		public boolean isCollidable(){
			return collidable;
			}
	}
	
	protected float x;
	protected float y;
	protected int id;
	private Texture texture;
	private TileType type;
	private boolean collideable;
	
	public Tile(int id, float x, float y) {
		this.id = id;
		this.x = x;
		this.y = y;
		
		texture = Art.getTextureByID(id);
		
		
	
		setType(id);
		
	}
	
	private void setType(int id){
		
		
		for(int i = 1; i <=5; i++){
			
			if(id == 1){
			type = TileType.Rock;
			
			}
			if(id == 2){
			type = TileType.Rocks;
			}
			if(id == 3){
			 type = TileType.Pond;
			}
			if(id == 4){
			type = TileType.Mushroom;
			}
			if(id == 5){
			type = TileType.Grass;
			}
			
			
		
			
			if(type == null){
				return;
			}
			
		
			
			if(type!= null){
				collideable = type.isCollidable();
			}
			
			}
		
		
		
	
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
	
	public TileType  getTileType(){
		return type;
	}
	
	public boolean isCollideable(){
		return collideable;
		
	}
	

}
