package com.javagroup.game.entity;

import java.awt.Graphics2D;

public abstract class Limb implements GameObject{
	
	private float x;
	
	private float y;
	
    public abstract void render(Graphics2D g,float xoff,float yoff);
   
    public abstract void update(long delta);
    
	public float getX() {
		return x;
	}


	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
	}


	public void setY(float y) {
		this.y = y;
	}

}
