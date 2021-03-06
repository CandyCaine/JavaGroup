package com.javagroup.game.entity;



import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.javagroup.game.graphics.animation.Animation;
import com.javagroup.game.graphics.image.SpriteSheet;
import com.javagroup.game.input.Input;

public class testEnt extends Entity{

	private Animation left;
	private Animation right;
	private Animation up;
	private Animation down;
	private Animation current;
	
	private SpriteSheet testSheet;
	
	private Limb limb;

	public testEnt(){
		limb = new TestLimb();
		testSheet = new SpriteSheet("/testSpriteSheet.png", 32);
		createAnimations();
		current = down;
		setX(320);
		setY(240);
	}
	
	@Override
	public void render(Graphics2D g) {
		g.drawImage(current.getImage(),Math.round(getX()),Math.round(getY()),null);
		limb.render(g, getX(), getY());
	}

	@Override
	public void update(int delta) {
		current.setPaused(true);
		if(Input.getInput().isKeyDown(KeyEvent.VK_A)){
			current = left;
			current.setPaused(false);
		}
		if(Input.getInput().isKeyDown(KeyEvent.VK_D)){
			current = right;
			current.setPaused(false);
		}
		if(Input.getInput().isKeyDown(KeyEvent.VK_W)){
			current = up;
			current.setPaused(false);
		}
		if(Input.getInput().isKeyDown(KeyEvent.VK_S)){
			current = down;
			current.setPaused(false);
		}
		
		limb.update(delta);
		current.update();
		
	}
	
	public void createAnimations(){
		
		//left
		{
			left = new Animation();
			left.addFrame(testSheet.getCell(3), 150);
			left.addFrame(testSheet.getCell(4), 150);
			left.addFrame(testSheet.getCell(5), 150);
			left.loop();
			
		}
		
		//right
		{
			right = new Animation();
			right.addFrame(testSheet.getCell(6), 150);
			right.addFrame(testSheet.getCell(7), 150);
			right.addFrame(testSheet.getCell(8), 150);
			right.loop();
		}
		
		//up
		{
			up = new Animation();
			up.addFrame(testSheet.getCell(9), 150);
			up.addFrame(testSheet.getCell(10), 150);
			up.addFrame(testSheet.getCell(11), 150);
			up.loop();
		}
		
		//down
		{
			down = new Animation();
			down.addFrame(testSheet.getCell(0), 150);
			down.addFrame(testSheet.getCell(1), 150);
			down.addFrame(testSheet.getCell(2), 150);
			down.loop();
		}
		
		
		
	}

}
