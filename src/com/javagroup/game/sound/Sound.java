package com.javagroup.game.sound;

import javax.sound.sampled.Clip;

import org.newdawn.easyogg.OggClip;

import com.javagroup.game.resource.Resource;

/**
 * Standard sound class
 * 
 * @author john
 *
 */
public class Sound implements Resource{
	
	private Clip sampledclip;//load on to this clip if file is a .wav file
	
	private OggClip oggclip;// load on to this clip if file is an ogg file
	
	private boolean loaded = false; //boolean to check if it is loaded
	
	/**
	 * Constructor of the sound will take in 
	 * 
	 * @param file - path to Sound in jar
	 */
	public Sound(String file){
		
	}

	@Override
	public void load() {
		
		loaded = true;
	}


	@Override
	public boolean isLoaded() {
		return loaded;
	}

}
