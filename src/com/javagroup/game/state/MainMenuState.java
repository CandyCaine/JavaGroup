package com.javagroup.game.state;


import java.awt.Graphics2D;
import java.awt.Image;

import com.javagroup.game.graphics.image.Font;
import com.javagroup.game.input.Input;

public class MainMenuState extends GameState {
	
	Image words;
	Image words2;

	public MainMenuState(StateType type) {
		super(type);
		words = Font.getFont().getLetters("MAIN MENU HERE");
		words2 = Font.getFont().getLetters("PRESS ANY KEY TO CONTINUE");
		
		
	}

	@Override
	public void update(int delta) {
		if(Input.getInput().checkForKeyPress())
			StateManager.getStateManager().setState(StateType.MAINGAME);
		
	}

	@Override
	public void render(Graphics2D g) {
		
		g.drawImage(words,40,200,500,32,null);
		g.drawImage(words2,20,300,600,32,null);
		
	}

}
