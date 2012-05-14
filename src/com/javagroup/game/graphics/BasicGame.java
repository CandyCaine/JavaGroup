package com.javagroup.game.graphics;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import com.javagroup.game.input.Input;


/**
 * Basic Game class, extend to make a game
 * 
 * @author john
 *
 */

public abstract class BasicGame implements Runnable{
	
	
	private BufferStrategy buffer;
	
	private Thread game;//Thread our game runs on
	
	private boolean running  = false;
	
	private Dimension size;
	
	private boolean fullscreen = false;
	
	private GameWindow gamewindow;
	
	private FullScreen fullwindow;
	
	private String title = "Name Goes Here :)";
	
	private int frames = 0;
	
	private int fps = 0;
	
	private long lastFPSUpdate = 0;
	
	
	public BasicGame(){
		size = new Dimension(640,480);
		gamewindow = new GameWindow(this);
	}
	
	
	
	/**
	 * sets the buffer to use, this makes it easier to switch 
	 * from one display to another
	 * 
	 * @param buffer - BufferStrategy
	 */
	public void setBuffer(BufferStrategy buffer){
		this.buffer = buffer;
	}
	

	@Override
	public void run() {
		initiate();
		
		
		int delta = 0;
		
		
		long lastUpdate = System.nanoTime();
		
		while(running){
			
			do{
				do{
					Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
					g.setColor(Color.black);
					g.fillRect(0, 0, size.width, size.height);
					gamewindow.setTitle(title + "   fps:"+ fps);
			
					render(g);
			
					g.dispose();
					buffer.show();
					
				}while(buffer.contentsRestored());
				
				
			}while(buffer.contentsLost());
			
			
			
			try {
				Thread.sleep(6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			delta =(int) (( System.nanoTime() - lastUpdate) /1000000L);
			
			update(delta);
			
			lastUpdate = System.nanoTime();
			
			updateFPS();
			
			
			
		}
		
	}
	
	public void updateFPS(){
		frames++;
		if(System.nanoTime() - lastFPSUpdate >= 1000000000L){
			fps = frames;
			frames = 0;
			lastFPSUpdate = System.nanoTime();
		}
		
		
	}
	
	/**
	 * Create a normal window with our game 
	 * if game is not started , this will start our game :)
	 */
	public void createWindow(){

		if(!isRunning()){
			gamewindow.createWindow();
			fullscreen = false;
		}
		 
			

			
	   if(fullscreen){
		
		  gamewindow.createWindow();
		   
		  fullscreen  = false;
		   
	   }
	   
		   
	}
	
	public void createFullSCreen(){
		if(fullscreen && fullwindow!=null)
			return;
	   if(!fullscreen){
		   
		   fullwindow.makeFullScreen();
		   
		   gamewindow.hideWindow();
		   Input.getInput().resetKeys();
		  
		   fullscreen = true;
		   
	   }
	}
	
	/**
	 * Set the size of the screen 
	 * 
	 * @param size - Dimension
	 */
	public void setScreenSize(Dimension size){
		this.size = size;
	}
	
	/**
	 * Gets the desired screen size (display mode w/o bit);
	 * @return Dimension
	 */
	public Dimension getScreenSize(){
		return size;
	}
	
	/**
	 * used to initiate the game
	 */
	public abstract void initiate();
	/**
	 * used to render our game graphics in 
	 * 
	 * @param g
	 */
	public abstract void render(Graphics2D g);
	
	/**
	 * used to update our game objects 
	 * 
	 * @param delta - elapsed time since last update 
	 */
	public abstract void update(int delta);
	
	
	public void start(){
		if(isRunning()){
			return;
		}
		
		game = new Thread(this);
		running = true;
		game.start();
	}
	
	public void stop(){
		if(!isRunning()){
			return;
		}
		
		running = false;
		try {
			game.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	/**
	 * checks to see if the game is currently running :)
	 * @return Boolean
	 */
	public boolean isRunning(){
		return running;
	}
	
	
	
	

}
