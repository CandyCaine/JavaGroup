package com.javagroup.game.graphics;

import java.awt.Canvas;


import javax.swing.JFrame;


public class GameWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	Canvas canvas;
	
	
	BasicGame screen;

	
	public GameWindow(BasicGame screen){
		this.screen = screen;
	    canvas = new Canvas();
		canvas.setSize(screen.getScreenSize());
		canvas.setIgnoreRepaint(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(false);
		
		this.setResizable(false);
		
		this.add(canvas);
		
		this.pack();
		
		this.setLocationRelativeTo(null);
		
		canvas.createBufferStrategy(2);
		
		this.setIgnoreRepaint(true);
		//this.requestFocus();
	
	}
	
	public void createWindow(){
		screen.setBuffer(canvas.getBufferStrategy());
		this.setVisible(true);
		
		
		if(!screen.isRunning())
			screen.start();
		
		canvas.requestFocus();
	}
	
	public void hideWindow(){
		this.setVisible(false);
	}
	


}