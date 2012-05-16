package com.javagroup.game.graphics.menu;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.javagroup.game.input.Input;

public class GameButton implements GameMenuItem {

	private float x = 0;

	private float y = 0;

	private int width = 100;

	private int height = 30;

	private boolean focused;

	public GameButton() {

	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public void setX(float x) {
		this.x = x;
	}

	@Override
	public void setY(float y) {
		this.y = y;

	}

	@Override
	public boolean isFocused() {
		return false;
	}

	@Override
	public void render(Graphics2D g) {

	}

	@Override
	public void update(int delta) {

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(Math.round(getX()),Math.round(getY()),getWidth(),getHeight());
	}

	@Override
	public void setBounds(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public boolean isMouseOverBounds() {
		Rectangle bounds = getBounds();
		if (Input.getInput().getMouseX() > bounds.x
				&& Input.getInput().getMouseX() < bounds.x + bounds.width
				&& Input.getInput().getMouseY() > bounds.y
				&& Input.getInput().getMouseY() < bounds.y + bounds.height)
			return true;
		else
			return false;
	}

}
