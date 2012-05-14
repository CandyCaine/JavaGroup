import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.javagroup.game.graphics.BasicGame;
import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.input.Input;
import com.javagroup.game.map.Map;

public class Game extends BasicGame{

	Map testMap;
	float x;
	float y;
	
	@Override
	public void initiate() {
		Art.init();
		testMap = new Map("Test", 32, 32);
	}

	@Override
	public void render(Graphics2D g) {
		testMap.render(g, Math.round(x), Math.round(y));
	}

	@Override
	public void update(int delta) {
		if (Input.getInput().isKeyDown(KeyEvent.VK_F)) {
			toggleFullScreen();
		}
		
		if(Input.getInput().isKeyDown(KeyEvent.VK_A)){
			x -= 0.1F * delta;
		}
		
		if (Input.getInput().isKeyDown(KeyEvent.VK_D)) {
			x += 0.1F * delta;
		}
		
	}
	
	public static void main(String[] args){
		Game game =  new Game();
		game.createWindow();
	}

}
