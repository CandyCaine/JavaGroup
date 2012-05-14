package com.javagroup.game.graphics;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;

import com.javagroup.game.input.Input;

public class FullScreen extends JFrame{
	private static final long serialVersionUID = 1L;

	private GraphicsDevice device;
	
	private BasicGame screen;
	
	public static final DisplayMode[] POSSIBLE_MODES = {
		new DisplayMode(640,480,32,DisplayMode.REFRESH_RATE_UNKNOWN),
		new DisplayMode(640,480,24,DisplayMode.REFRESH_RATE_UNKNOWN),
		new DisplayMode(640,480,16,DisplayMode.REFRESH_RATE_UNKNOWN),
	};
	
	public FullScreen(BasicGame gamescreen){
		this.screen = gamescreen;
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		device = env.getDefaultScreenDevice();
		
	}
	
	public void makeFullScreen(){
		DisplayMode displaymode = findFirstCompatibleMode(getCompatibleDisplayModes());
		
		
		this.setUndecorated(true);
		this.setIgnoreRepaint(true);
		this.setResizable(false);
		
		device.setFullScreenWindow(this);
		
		if(displaymode != null && device.isDisplayChangeSupported()){
			try{
				device.setDisplayMode(displaymode);
			}catch(IllegalArgumentException e){
				e.printStackTrace();
			}
		}
		this.createBufferStrategy(2);
		screen.setBuffer(this.getBufferStrategy());
		Input.getInput().addListeners(this);
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void restoreScreen(){
   	 Window window = device.getFullScreenWindow();
   	 if(window!=null)
   		 window.dispose();
   	 device.setFullScreenWindow(null);
    }
	
	
	public DisplayMode[] getCompatibleDisplayModes(){
		return device.getDisplayModes();
	}
	
	public DisplayMode findFirstCompatibleMode(DisplayMode modes[]){
		DisplayMode goodModes[] = device.getDisplayModes();
		for(int i = 0 ; i < modes.length; i++){
			for(int j = 0; j < goodModes.length;j++){
				if(displayModesMatch(modes[i],goodModes[j])){
					return modes[i];
				}
			}
		}
		return null;
	}
	
	public boolean displayModesMatch(DisplayMode mode1,DisplayMode mode2){
		
		if(mode1.getWidth() != mode2.getWidth() || mode1.getWidth() != mode2.getWidth()){
			return false;
		}
		if(mode1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && mode2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && mode1.getBitDepth() != mode2.getBitDepth()){
			return false;
		}
		if(mode1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && mode2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && mode1.getRefreshRate() != mode2.getRefreshRate()){
			return false;
		}
		
		return true;
	}

}
