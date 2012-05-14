import java.awt.Graphics2D;

import com.javagroup.game.graphics.BasicGame;
import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.map.Map;

public class Game extends BasicGame {

	private Map testMap;
	
	@Override
	public void initiate() {
		Art.init();
		testMap = new Map("Test", 32, 32);
	}

	@Override
	public void render(Graphics2D g) {
		testMap.render(g, 0, 0);
	}

	@Override
	public void update(int delta) {
		
	}
	
	public static void main(String[] args){
		Game game =  new Game();
		game.createWindow();
	}

}
