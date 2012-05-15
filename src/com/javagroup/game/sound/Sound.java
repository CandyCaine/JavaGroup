package com.javagroup.game.sound;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
	
	private AudioInputStream in; //sound input stream(sampled only)
	
	private FloatControl gainControl; //control for sampled sound gain
	
	private OggClip oggclip;// load on to this clip if file is an ogg file
	
	private boolean loaded = false; //boolean to check if it is loaded
	
	private String file;//name of the file
	
	/**
	 * Constructor of the sound will take in 
	 * 
	 * @param file - path to Sound in jar
	 */
	public Sound(String file){
		this.file = file;
	}

	@Override
	public void load() {
		
		//load accordingly in here
		
		if(isOGG()){
			//if its an ogg load up an ogg clip
			try {
				oggclip = new OggClip(Sound.class.getResourceAsStream(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			//if its not an ogg file try to load it as a sampled file 
			try {
				in = AudioSystem.getAudioInputStream(Sound.class.getResource(file));
				sampledclip = AudioSystem.getClip(); 
				
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
		}
			
		
		
		loaded = true;
	}
	
	/**
	 * Plays the sound once 
	 */
	public void play(){
		
	}
	/**
	 * Loops the sound over and over again
	 */
	public void loop(){
		
	}
	/**
	 * Pauses the sound
	 */
	public void pause(){
		
	}
	/**
	 * Stops the sound
	 */
	public void stop(){
		
	}
	/**
	 * set the gain for the loaded clip(aka controls the volume)
	 * @param gain -  amount must be between 0.0f and 1.0f
	 */
	public void setGain(float gain){
		
	}


	@Override
	public boolean isLoaded() {
		return loaded;
	}
	
	/**
	 * check to to see if the file is an ogg file or not
	 * @return true if the file extension is ogg
	 */
	private boolean isOGG(){
		  String ext="";
		  int mid= file.lastIndexOf(".");
		  ext=file.substring(mid+1,file.length());  
		 
		  if(ext.equalsIgnoreCase("ogg")){
			  return true;
		  }else{
			  return false;
		  }
	}

}
