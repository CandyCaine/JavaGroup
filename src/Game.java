import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.javagroup.game.graphics.BasicGame;
import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.graphics.particle.Emitter;
import com.javagroup.game.graphics.particle.ParticleSystem;
import com.javagroup.game.input.Input;
import com.javagroup.game.map.Map;

public class Game extends BasicGame{

	Map testMap;
	float x;
	float y;
	
	ParticleSystem particleSystem;
	Emitter emitter, emitter2, emitter3;
	
	@Override
	public void initiate() {
		Art.init();
		testMap = new Map("Test", 32, 32);
		particleSystem = new ParticleSystem();
		emitter = new Emitter(1000, 1.0F, 50);
		emitter.setLocation(300, 300);
		emitter.setImage(Art.getTileSheet().getImage(64, 32, 8, 8));
		particleSystem.addEmitter(emitter);
		emitter2 = new Emitter(1000, 1.0F, 50);
		emitter2.setLocation(300, 300);
		emitter2.setImage(Art.getTileSheet().getImage(72, 32, 8, 8));
		particleSystem.addEmitter(emitter2);
		emitter3 = new Emitter(1000, 1.0F, 50);
		emitter3.setLocation(300, 300);
		emitter3.setImage(Art.getTileSheet().getImage(80, 32, 8, 8));
		particleSystem.addEmitter(emitter3);
	}

	@Override
	public void render(Graphics2D g) {
		testMap.render(g, Math.round(x), Math.round(y));
		particleSystem.render(g);
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
		
		particleSystem.update();
		
	}
	
	public static void main(String[] args){
		Game game =  new Game();
		game.createWindow();
	}

}
