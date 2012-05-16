package com.javagroup.game.state;


import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.javagroup.game.entity.testEnt;
import com.javagroup.game.graphics.Display;
import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.graphics.image.Font;
import com.javagroup.game.graphics.particle.Effect;
import com.javagroup.game.graphics.particle.Emitter;
import com.javagroup.game.graphics.particle.ParticleSystem;
import com.javagroup.game.graphics.particle.Effect.EffectType;
import com.javagroup.game.input.Input;
import com.javagroup.game.map.Map;
import com.javagroup.game.map.camera.Camera;
import com.javagroup.game.sound.Sound;
import com.javagroup.game.world.World;


public class MainGameState extends GameState{
	
//	Map testMap;
	World world;


	ParticleSystem particleSystem;
	Emitter emitter, emitter2, emitter3;
	BufferedImage testFont,testFont2;
	Sound sound ;



	testEnt testent;

	public MainGameState(StateType type) {
		super(type);
		// TODO Auto-generated constructor stub
		
		//testFont = Font.getFont().getLetters("PARTICLES");
		
		testFont2 = Font.getFont().getLetters("TEST0908978"); //<----Gives a weird error
		
		sound = new Sound("/creepymusicO.ogg");
		sound.load();
		sound.setGain(.99f);
		sound.loop();

		// Testing
		{
			testent = new testEnt();
		//	testMap = new Map("Test",6, 5);

			particleSystem = new ParticleSystem();
			emitter = new Emitter(1000, 2.5F, 100);
			emitter.setLocation(-300, 250);
			emitter.setImage(Art.getTileSheet().getImage(64, 32, 8, 8));
			particleSystem.addEmitter(emitter);
			emitter2 = new Emitter(1000, 2.0F, 100);
			emitter2.setLocation(-300, 250);
			emitter2.setImage(Art.getTileSheet().getImage(72, 32, 8, 8));
			particleSystem.addEmitter(emitter2);
			emitter3 = new Emitter(1000, 1.5F, 100);
			emitter3.setLocation(-300, 250);
			emitter3.setImage(Art.getTileSheet().getImage(80, 32, 8, 8));
			particleSystem.addEmitter(emitter3);


			//Effect.playEffect(EffectType.BloodEffect, 100, 200);
			Effect.genericParticleEffect();
			Effect.playEffect(EffectType.BloodEffect, 500, 50);


		}
		
		world = new World(2, 2);
	}

	@Override
	public void render(Graphics2D g) {
		world.render(g);
		//testMap.render(g);
		particleSystem.render(g);
		//g.drawImage(testFont, Math.round(Camera.getCamera().getXOff()) + (-350), (int) Camera.getCamera().getYOff(), testFont.getWidth(), testFont.getHeight(), null);
		g.drawImage(testFont2, Math.round(Camera.getCamera().getXOff()) + (-600), (int) Camera.getCamera().getYOff(), null);

		testent.render(g);
		Effect.getEffect().render(g);

	}

	@Override
	public void update(int delta) {
		if (Input.getInput().isKeyDown(KeyEvent.VK_F)) {
			Display.getDisplay().toggleFullScreen();
		}

		if (Input.getInput().isKeyDown(KeyEvent.VK_A)) {
			Camera.getCamera().setXOff(Camera.getCamera().getXOff()+ 0.1F * delta) ;
		}

		if (Input.getInput().isKeyDown(KeyEvent.VK_D)) {
			Camera.getCamera().setXOff(Camera.getCamera().getXOff()- 0.1F * delta) ;
		}
		if (Input.getInput().isKeyDown(KeyEvent.VK_W)) {
			Camera.getCamera().setYOff(Camera.getCamera().getYOff()+ 0.1F * delta) ;
		}

		if (Input.getInput().isKeyDown(KeyEvent.VK_S)) {
			Camera.getCamera().setYOff(Camera.getCamera().getYOff()- 0.1F * delta) ;
		}

		testent.update(delta);
	
	}
}
