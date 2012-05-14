package com.javagroup.game.graphics.particle.emitter;

import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.graphics.particle.Emitter;

public class BloodEmitter extends Emitter {

	public BloodEmitter(long life, float speed, int maxParticles) {
		super(life, speed, maxParticles);
		setImage(Art.getTileSheet().getImage(88,32,8,8));
		setEmitterLife(900);
	}

}
