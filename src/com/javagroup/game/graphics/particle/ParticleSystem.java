package com.javagroup.game.graphics.particle;

import java.awt.Graphics;
import java.util.ArrayList;

public class ParticleSystem {

	private ArrayList<Emitter> emitters;

	public ParticleSystem() {
		emitters = new ArrayList<Emitter>();
	}

	public void addEmitter(Emitter emitter) {
		emitters.add(emitter);
	}

	public void removeEmitter(Emitter emitter) {
		emitters.remove(emitter);
	}

	public void update() {
		for (int i = 0; i < emitters.size(); i++) {
			emitters.get(i).update();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < emitters.size(); i++) {
			emitters.get(i).render(g);
		}
	}
}
