package com.javagroup.game.input;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener, FocusListener {

	private  boolean[] keys;
	private  boolean leftMouseButton;
	private  boolean middleMouseButton;
	private  boolean rightMouseButton;
	private  boolean focus;
	private  Point mousePos;
	
	private static Input input = new Input();
	
	
	public static enum MouseButton {
		LEFT_MOUSE_BUTTON,
		MIDDLE_MOUSE_BUTTON,
		RIGHT_MOUSE_BUTTON,
		ANY_MOUSE_BUTTON;
	}
	
	public static Input getInput(){
		return input;
	}
	
	private Input() {
		keys = new boolean[1000];
		mousePos = new Point(0, 0);
	}
	
	public void resetKeys(){
		for(int i = 0; i < keys.length;i++){
			keys[i] = false;
		}
	}
	
	public void addListeners(Component e){
		e.addKeyListener(this);
		e.addFocusListener(this);
		e.addMouseListener(this);
		e.addMouseMotionListener(this);
	}
	
	public boolean isKeyDown(int key) {
		return keys[key];
	}
	
	public boolean isMouseDown(MouseButton button) {
		if (button == MouseButton.LEFT_MOUSE_BUTTON) {
			return leftMouseButton;
		} else if (button == MouseButton.MIDDLE_MOUSE_BUTTON) {
			return middleMouseButton;
		} else if (button == MouseButton.RIGHT_MOUSE_BUTTON) {
			return rightMouseButton;
		} else if (button == MouseButton.ANY_MOUSE_BUTTON) {
			if (leftMouseButton || middleMouseButton || rightMouseButton) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasFocus() {
		return focus;
	}
	
	public Point getMousePos() {
		return mousePos;
	}
	
	public int getMouseX() {
		return mousePos.x;
	}
	
	public int getMouseY() {
		return mousePos.y;
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		focus = true;
	}

	@Override
	public void focusLost(FocusEvent e) {
		focus = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mousePos = e.getPoint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePos = e.getPoint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mousePos = e.getPoint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mousePos = e.getPoint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 0) {
			leftMouseButton = true;
		} else if (e.getButton() == 1) {
			middleMouseButton = true;
		} else if (e.getButton() == 2) {
			rightMouseButton = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == 0) {
			leftMouseButton = false;
		} else if (e.getButton() == 1) {
			middleMouseButton = false;
		} else if (e.getButton() == 2) {
			rightMouseButton = false;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() >= 0 && e.getKeyCode() <= keys.length) {
			keys[e.getKeyCode()] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() >= 0 && e.getKeyCode() <= keys.length) {
			keys[e.getKeyCode()] = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
