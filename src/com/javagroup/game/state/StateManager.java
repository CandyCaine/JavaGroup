package com.javagroup.game.state;

import java.util.ArrayList;

import com.javagroup.game.state.GameState.StateType;

public class StateManager {

	private GameState currentState;
	private ArrayList<GameState> states;
	
	public StateManager() {
		
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
