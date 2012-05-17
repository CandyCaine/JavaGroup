package com.javagroup.game.world;

public abstract class Biome {
	
	public int[] availableTiles;
	
	public Biome(int[] availableTiles) {
		this.availableTiles = availableTiles;
	}
	
	public int[] getAvailableTiles() {
		return availableTiles;
	}
}
