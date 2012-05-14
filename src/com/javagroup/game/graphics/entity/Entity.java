package com.javagroup.game.graphics.entity;

import java.awt.Graphics2D;

public abstract class Entity implements GameObject{
	
	private float x;
	
	private float y;
	
	
	private int xDir;
	
	private int yDir;
	
	private float xSpeed;
	
	private float ySpeed;
	

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public void setX(float x) {
		this.x = x;
	}

	@Override
	public void setY(float y) {
		this.y = y;
	}
	
	public int getXDir(){
		return xDir;
	}
	
	public int getYDir(){
		return yDir;
	}
	
	public void setXDir(int xDir){
		this.xDir = xDir;
	}

	public void setYDir(int yDir){
		this.yDir = yDir;
	}
	
	
	public void setXSpeed(float xspeed){
		this.xSpeed = xspeed;
	}
	
	public void setYSpeed(float yspeed){
		this.ySpeed = yspeed;
	}
	
	public float getYSpeed(){
		return ySpeed;
	}
	
	public float getXSpeed(){
		return xSpeed;
	}
	
	public float getXVelocity(){
		return getXDir() * xSpeed;
	}
	
	public float getYVelocity(){
		return getYDir() * ySpeed;
	}
	
	public void setXVelocity(float xVelocity){
		setXDir(0);
		setYSpeed(0);
		if(xVelocity > 0 ){
			setXSpeed(xVelocity);
			setXDir(1);
		}else{
			setXSpeed(xVelocity);
			setXDir(-1);
		}
	}
	
	public void setYVelocity(float yVelocity){
		setYDir(0);
		setYSpeed(0);
		if(yVelocity > 0 ){
			setYSpeed(yVelocity);
			setYDir(1);
		}else{
			setYSpeed(yVelocity);
			setYDir(-1);
		}
	}
	
	public abstract void render(Graphics2D g);
	
	public abstract void update(int delta);
		

}
