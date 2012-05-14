package com.javagroup.game.graphics.particle;

import java.awt.Graphics;

import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.graphics.particle.emitter.BloodEmitter;


public class Effect {

	public static enum EffectType {
		BloodEffect;
	}
	
	private static ParticleSystem particleSystem;
	
	public Effect() {
		particleSystem = new ParticleSystem();
	}
	
	public static void playEffect(EffectType type, float x, float y) {
		if (type == EffectType.BloodEffect) {
			Emitter emitter = new BloodEmitter(500, 0.15F, 100);
			emitter.setLocation(-410, 50);
			particleSystem.addEmitter(emitter);
		}
	}
	
	public static void genericParticleEffect() {
		Emitter emitter1, emitter2, emitter3;
		emitter1 = new Emitter(1000L, 1.0F, 100);
		emitter1.setImage(Art.getTileSheet().getImage(64, 32, 8, 8));
		emitter1.setLocation(-310, 300);
		emitter1.setEmitterLife(100000);
		particleSystem.addEmitter(emitter1);
		emitter2 = new Emitter(1000L, 1.0F, 100);
		emitter2.setImage(Art.getTileSheet().getImage(72, 32, 8, 8));
		emitter2.setLocation(-310, 300);
		emitter2.setEmitterLife(100000);
		particleSystem.addEmitter(emitter2);
		emitter3 = new Emitter(1000L, 1.0F, 100);
		emitter3.setImage(Art.getTileSheet().getImage(80, 32, 8, 8));
		emitter3.setLocation(-310, 300);
		emitter3.setEmitterLife(100000);
		particleSystem.addEmitter(emitter3);
	}
	
	public void update(float xOffset, float yOffset) {
		particleSystem.update(xOffset, yOffset);
	}
	
	public void render(Graphics g) {
		particleSystem.render(g);
	}
	
}
