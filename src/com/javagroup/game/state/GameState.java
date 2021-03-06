package com.javagroup.game.state;

import java.awt.Graphics2D;

public abstract class GameState{

	
	public static enum StateType {
		
		MAIN_MENU	(0, "MainMenu"),
		MAINGAME		(1, "MainGame");
		
		private int id;
		private String name;		
		StateType(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public int getID() {
			return id;
		}
		
		public String getName() {
			return name;
		}
	}
	
	public StateType type;
	
	public GameState(StateType type) {
		this.type = type;
	}
	
	public StateType getStateType() {
		return type;
	}
	
	public abstract void update(int delta);
	
	public abstract void render(Graphics2D g);
}
