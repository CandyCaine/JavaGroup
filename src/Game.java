import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.javagroup.game.graphics.BasicGame;
<<<<<<< HEAD
import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.map.Map;
=======
import com.javagroup.game.input.Input;
>>>>>>> 06e39b4c5ea5ec8ad824aafe574006ebf66953af

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
<<<<<<< HEAD
=======
		if(Input.getInput().isKeyDown(KeyEvent.VK_A)){
			System.out.println("lol");
		}
>>>>>>> 06e39b4c5ea5ec8ad824aafe574006ebf66953af
		
	}
	
	public static void main(String[] args){
		Game game =  new Game();
		game.createWindow();
	}

}
