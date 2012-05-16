package com.javagroup.game.graphics.menu;

import java.awt.Graphics2D;

public interface MenuInterface {

	public void add(GameMenuItem item, float x, float y);
	
	public void render(Graphics2D g);
	
	public void update(int delta);
}
