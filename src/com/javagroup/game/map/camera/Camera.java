package com.javagroup.game.map.camera;

public class Camera {
 
	//----------------------------SINGLETON----------------////
	private static Camera camera = new Camera();
	
	private Camera(){
		
	}
	/**
	 * get the single instance of this class 
	 * @return Return teh camera object 
	 */
	public static Camera getCamera(){
		return camera;
	}
	
	private float xoffSet = 0;
	
	private float yoffSet = 0;
	/**
	 * 
	 * @return the x offset of the camera
	 */
	public float getXOff(){
		return xoffSet;
	}
	/**
	 * 
	 * @return the y offset of the camera
	 */
	public float getYOff(){
		return yoffSet;
	}
	
	/**
	 * 
	 * @param xoff set teh offset of the camera
	 */
	public void setXOff(float xoff){
		this.xoffSet = xoff;
	}
	
	/**
	 * 
	 * @param yoff set the offset of the camera
	 */
	public void setYOff(float yoff){
		this.yoffSet = yoff;
	}
	
	
	
}
