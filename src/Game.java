import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.javagroup.game.graphics.BasicGame;
import com.javagroup.game.input.Input;

public class Game extends BasicGame{

	@Override
	public void initiate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int delta) {
		if(Input.getInput().isKeyDown(KeyEvent.VK_A)){
			System.out.println("lol");
		}
		
	}
	
	public static void main(String[] args){
		Game game =  new Game();
		game.createWindow();
	}

}
