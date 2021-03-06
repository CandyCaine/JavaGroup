package com.javagroup.game.graphics.particle;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public class Emitter {

	public Image image;
	public long life;
	public long startTime;
	public float speed;
	public float xDir;
	public float yDir;

	public boolean active;

	public int maxParticles;
	public long particleLife;
	public boolean hasImage = false;

	public float x;
	public float y;

	public ArrayList<Particle> particles;
	public Random r;

	public Emitter(long life, float speed, int maxParticles) {
		particles = new ArrayList<Particle>();
		r = new Random();
		startTime = System.currentTimeMillis();
		particleLife = life;
		this.speed = speed;
		this.maxParticles = maxParticles;
		active = true;
		life = Long.MAX_VALUE;
	}

	public void setLocation(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public long getLife() {
		return particleLife;
	}

	public void setEmitterLife(long life) {
		this.life = life;
	}
	
	public long getEmitterLife() {
		return life;
	}
	
	public float getSpeed() {
		return speed;
	}

	public void setImage(Image image) {
		this.image = image;
		hasImage = true;
	}

	public Image getImage() {
		return image;
	}

	public boolean hasImage() {
		return hasImage;
	}

	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void update(float xOffset, float yOffset) {
			for (int i = 0; i < particles.size(); i++) {
				particles.get(i).update(this, xOffset, yOffset);

				if (!particles.get(i).isAlive()) {
					particles.remove(i);
				}
			}

			if (particles.size() < maxParticles) {
				particles.add(new Particle(xOffset + x, yOffset + y, r.nextInt(360), r.nextInt(360)));
			}
		
			if (System.currentTimeMillis() > startTime + life) {
				setActive(false);
			}
	}

	public void render(Graphics g) {
		if (active) {
			for (int i = 0; i < particles.size(); i++) {
				particles.get(i).render(this, g);
			}
		}
	}
}
