package com.javagroup.game.resource;

import java.util.LinkedList;

/**
 * Will Load Resources at the start of our game
 * so we don't end up with a gray screen or lag in between 
 * 
 * @author john
 *
 */
public class LoadManager {
	
	private static LoadManager loadmanager = new LoadManager();
	
	private LinkedList<Resource> resources;
	
	private double loaded = 0;
	
	private double tobeLoaded = 0;
	
	private double percentage;
	
	/**
	 * Gets the one instance of our load manager
	 * 
	 * @return LoadManager instance
	 */
	public static LoadManager getLoader(){
		return loadmanager;
		
	}
	
	private LoadManager(){
		resources = new LinkedList<Resource>();
		percentage = 0;
	}
	
	/**
	 * Add a resource to be loaded on to 
	 * @param resource
	 */
	public void addResource(Resource resource){
		resources.add(resource);
		tobeLoaded ++;
	}
	
	/**
	 * Load and remove the first resource on the list;
	 */
	public void loadResource(){
		resources.poll().load();
		loaded++;
		
	}
	
	/**
	 * Gets the percentage of how many items have been loaded
	 * 
	 * @return double needs to be formated accordingly
	 */
	public double getLoadPercentage(){
		percentage = loaded/tobeLoaded;
		return percentage;	
	}
	
	/**
	 * check to see if you are done loading
	 * @return true if the percentage of files loaded is equal to 100
	 */
	public boolean doneLoading(){
		if(getLoadPercentage() != 100)
			return false;
		else
			return true;
			
	}

}
