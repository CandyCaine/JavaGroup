import java.awt.Graphics2D;

import com.javagroup.game.graphics.BasicGame;
import com.javagroup.game.state.StateManager;


public class Game extends BasicGame {



	

	public void initiate() {


	}

	@Override
	public void render(Graphics2D g) {

		StateManager.getStateManager().getCurrentState().render(g);
	}

	@Override
	public void update(int delta) {
		
		StateManager.getStateManager().getCurrentState().update(delta);
	
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.createWindow();
	}

}
