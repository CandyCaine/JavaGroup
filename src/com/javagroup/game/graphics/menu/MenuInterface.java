package com.javagroup.game.graphics.menu;

import java.awt.Graphics2D;
/**
 * MenuInterface 
 * 
 * @author john
 *
 */

public interface MenuInterface {
	
	/**
	 * get the x value location for this menu
	 * @return the x location of this item(usually 0,0)
	 */
	public float getX();
	
	/**
	 * get the x value location for this menu
	 * @return the x location of this item(usually 0,0)
	 */
	public float getY();
	/**
	 * set the x location of the menu
	 * @param x 
	 */
	public void setX(float x);
	/**
	 * set the y location of th emenu
	 * @param y
	 */
	public void setY(float y);
	/**
	 * add a menu item to the menu at the desired location;
	 * 
	 * @param item
	 * @param x
	 * @param y
	 */
	public void add(GameMenuItem item, float x, float y);
	
	/**
	 * render the menu 
	 * @param g
	 */
	public void render(Graphics2D g);
	/**
	 * update the menu(still not sure if delta will be needed)
	 * @param delta
	 */
	public void update(int delta);
}
