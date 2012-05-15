package com.javagroup.game.resource;
/**
 * Interface used to help load resources
 * 
 * @author john
 *
 */
public interface Resource {
	/**
	 * Load the resource here 
	 */
	public void load();
	/**
	 * check to see if the resource has been loaded
	 * @return true if resource is loaded false if it has not been loaded
	 */
	public boolean isLoaded();

}
