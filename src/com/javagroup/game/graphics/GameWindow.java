package com.javagroup.game.graphics;

import java.awt.Canvas;


import javax.swing.JFrame;

import com.javagroup.game.input.Input;


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
		Input.getInput().addListeners(canvas);
		
		if(!screen.isRunning())
			screen.start();
		
		canvas.requestFocus();
	}
	
	public void hideWindow(){
		Input.getInput().removeListeners(canvas);
		this.setVisible(false);
	}
	


}
