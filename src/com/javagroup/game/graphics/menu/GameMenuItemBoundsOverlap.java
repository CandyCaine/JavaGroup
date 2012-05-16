package com.javagroup.game.graphics.menu;
/**
 * Generic Exception thrown when menu items overlap
 * 
 * @author john
 *
 */
public class GameMenuItemBoundsOverlap extends Exception{
	private static final long serialVersionUID = 1L;
	
	public GameMenuItemBoundsOverlap(String details){
		super(details);
	}

}
