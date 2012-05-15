package com.javagroup.game.graphics;

public class Display {
	
	private static Display display = new Display();
	
	BasicGame game;
	
	public static Display getDisplay(){
		return display;
	}
	
	private Display(){
		
	}
	
	public void addGame(BasicGame game){
		this.game = game;
	}
	
	public void toggleFullScreen(){
		if(game!=null)
			game.toggleFullScreen();
	}

}
