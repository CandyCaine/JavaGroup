package com.javagroup.game.graphics.particle;

import java.awt.Color;
import java.awt.Graphics;

public class Particle {

	private boolean alive;

	private float x;
	private float y;
	
	private float xDir;
	private float yDir;
	
	private long birthTime;
	
	public Particle(float x, float y, float xDir, float yDir) {
		this.x = x;
		this.y = y;
		this.xDir = xDir;
		this.yDir = yDir;
		birthTime = System.currentTimeMillis();
		alive = true;
	}

	public boolean isAlive() {
		return alive;
	}

	public void update(Emitter emitter, float xOffset, float yOffset) {
		x += (emitter.getSpeed() * Math.cos(xDir));
		y += (emitter.getSpeed() * Math.sin(yDir));
		
		if (System.currentTimeMillis() > birthTime + emitter.getLife()) {
			alive = false;
		}
	}

	public void render(Emitter emitter, Graphics g) {
		g.setColor(Color.magenta);
		if (emitter.hasImage()) {
			g.drawImage(emitter.getImage(), (int)x, (int)y, null);
		} else {
			g.fillRect((int)x, (int)y, 8, 8);
		}
	}
}
