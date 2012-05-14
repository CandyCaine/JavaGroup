package com.javagroup.game.graphics.particle;

import java.awt.Graphics;

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
	
	public void update(float xOffset, float yOffset) {
		particleSystem.update(xOffset, yOffset);
	}
	
	public void render(Graphics g) {
		particleSystem.render(g);
	}
	
}
