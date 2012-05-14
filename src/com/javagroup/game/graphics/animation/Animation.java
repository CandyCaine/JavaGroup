package com.javagroup.game.graphics.animation;

import java.awt.Image;
import java.util.ArrayList;


public class Animation implements Cloneable{

	private ArrayList<AnimationFrame> frames;
	private int currentFrame;
	private long animationTime;
	private long totalDuration;
	private boolean alive = false;
	private boolean loop = false;
	private long lastCheck = 0;
	
	public Animation(){
		frames = new ArrayList<AnimationFrame>();
		totalDuration = 0;
	}

	public void addFrame(Image image,long duration){
		totalDuration+=duration;
		frames.add(new AnimationFrame(image, totalDuration));
	}
	
	public void start(){
		animationTime = 0;
		currentFrame = 0;
		lastCheck = System.nanoTime();
		alive = true;
	}
	
	public boolean isAlive(){
		return alive;
	}
	
	public boolean isLooped(){
		return loop;
	}

	
	public void loop(){
		start();
		loop = true;
	}
	
	public void update(){
		if(isAlive()){
			
			int elapsedTime = (int)((System.nanoTime()-lastCheck)/1000000L);
			if(frames.size() > 1){
				animationTime+=elapsedTime;
			
				if(animationTime >= totalDuration){
					if(isLooped()){
						animationTime = animationTime % totalDuration;
						currentFrame = 0;
					}else{
						currentFrame = 0;
						alive = false;
					}
				
				}
			
				if(animationTime > getFrame(currentFrame).endTime){
					currentFrame++;
				}
			}
			lastCheck = System.nanoTime();
		}
		
		
		
	}
	
	
	public Image getImage(){
		if(frames.size() == 0){
			return null;
		}else{
			return getFrame(currentFrame).image;
		}
	}
	
	private AnimationFrame getFrame(int frame){
		return frames.get(frame);
	}
	
	public Animation clone(){
		Animation clone = null;
		try {
			clone = (Animation)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		clone.frames = new ArrayList<Animation.AnimationFrame>();
		for(int i = 0;i<frames.size();i++){
			clone.frames.add(frames.get(i).clone());
		}
			
		return clone;
	}
	
	
	private class AnimationFrame implements Cloneable{
		
		Image image;
		long endTime;
		
		public AnimationFrame(Image image,long endTime){
			this.image = image;
			this.endTime = endTime;
		}
		
		public AnimationFrame clone(){
			AnimationFrame frame = new AnimationFrame(image,endTime);
			/*
			 * AnimationFrame frame = null;
			
			BufferedImage cloneimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics g = cloneimage.createGraphics();
			g.drawImage(image,0,0,null);
			frame.image = cloneimage;
			frame.endTime = this.endTime; */
			
			return frame;
		}
	}
	
}

