package com.javagroup.game.world;

import java.util.ArrayList;

public class ChunkList {

	private ArrayList<Chunk> chunkList;
	
	public ChunkList() {
		chunkList = new ArrayList<Chunk>();
	}
	
	public ArrayList<Chunk> getList() {
		return chunkList;
	}
	
	public void addChunk(Chunk chunk) {
		chunkList.add(chunk);
	}
	
	public void removeChunk(Chunk chunk) {
		chunkList.remove(chunk);
	}
	
	public void remove(int index) {
		chunkList.remove(index);
	}
	
	public int size() {
		return chunkList.size();
	}
}
