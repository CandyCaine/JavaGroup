package com.javagroup.game.graphics.menu;

import java.awt.Graphics2D;
import java.awt.Rectangle;
/**
 * Basic interface for all game menu objects
 * 
 * @author john
 *
 */
public interface GameMenuItem {

	/**
	 * 
	 * @return the x position of the item
	 */
	public float getX();
	
	/**
	 * 
	 * @return the y position of the item
	 */
	public float getY();
	
	/**
	 * set the x location of the item in the menu
	 * @param x - the x location of the menu item relative to the menu location
	 */
	public void setX(float x);
	/**
	 * set the  y location of the item in the menu 
	 * @param y - the y location of the item relative to the menu
	 */
	public void setY(float y);
	
	/**
	 * gets the bounds of the menu item, 
	 * @return returns a rectangle with the width,height and x and y of the item
	 */
	public Rectangle getBounds();
	
	/**
	 * set the bounds of the item (aka width and height)
	 * @param width - width of the item 
	 * @param height - height of item
	 */
	public void setBounds(int width,int height);
	
	/**
	 * get the with of the item
	 * @return the width of the item
	 */
	public int getWidth();
	
	/**
	 * get the height of the item 
	 * 
	 * @return the height of the item
	 */
	public int getHeight();
	
	/**
	 * check to see if the mouse is over the items bounds
	 * @return true if the mouse x and y are within the items boundries 
	 */
	public boolean isMouseOverBounds();
	
	/**
	 * checks to see if the user has focused in on this item
	 * this is more or less a pseudo feature
	 * @return true if the item is focused
	 */
	public boolean isFocused();
	/**
	 * render this item 
	 * @param g - graphics context to render this item on
	 */
	public void render(Graphics2D g);
	/**
	 * update this item/ delta might not be needed , unless working with animated buttons :)
	 * @param delta
	 */
	public void update(int delta);
	
	

}
