package com.javagroup.game.world.biome;

import com.javagroup.game.world.Biome;

public class GrassBiome extends Biome {
	public static int[] availableTiles = {0, 1, 2, 4};
	
	public GrassBiome() {
		super(availableTiles);
	}

}
