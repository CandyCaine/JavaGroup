package com.javagroup.game.state;

import java.util.ArrayList;

import com.javagroup.game.state.GameState.StateType;

public class StateManager {

	private GameState currentState;
	private ArrayList<GameState> states;
	
	private static StateManager manager = new StateManager();
	
	private StateManager() {
		states = new ArrayList<GameState>();
		
	}
	
	public void initiate(){
		states.add(new MainMenuState(StateType.MAIN_MENU));
		states.add(new MainGameState(StateType.MAINGAME));
		setState(StateType.MAIN_MENU);
	}
	
	public static StateManager getStateManager(){
		return manager;
	}
	
	public GameState getCurrentState() {
		return currentState;
	}
	
	public GameState getState(StateType type) {
		for (GameState state : states) {
			if (state.getStateType() == type) {
				return state;
			}
		}
		return null;
	}
	
	public void setState(StateType type) {
		for (GameState state : states) {
			if (state.getStateType() == type) {
				currentState = state;
			}
		}
	}
}
