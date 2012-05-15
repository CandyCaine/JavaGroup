package com.javagroup.game.entity;
/**
 * Every object in the game will implement this interface
 * @author john
 *
 */
public interface GameObject {
	/**
	 * gets the x position of the object
	 * 
	 * @return float
 	 */
	public float getX();
	/**
	 * get the y position of the object
	 * 
	 * @return float
	 */
	public float getY();
	
	/**
	 * sets the x position of the object
	 * @param x - position of the object
	 */
    public void setX(float x);

    public void setY(float y);
}
