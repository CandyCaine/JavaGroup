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
	
	public void setX(float x);
	
	public void setY(float y);

	public void add(GameMenuItem item, float x, float y);
	
	public void render(Graphics2D g);
	
	public void update(int delta);
}
