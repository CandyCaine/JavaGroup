import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.javagroup.game.graphics.BasicGame;
import com.javagroup.game.graphics.animation.Animation;
import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.graphics.image.Font;
import com.javagroup.game.graphics.image.SpriteSheet;
import com.javagroup.game.graphics.particle.Emitter;
import com.javagroup.game.graphics.particle.ParticleSystem;
import com.javagroup.game.graphics.particle.emitter.BloodEmitter;
import com.javagroup.game.input.Input;
import com.javagroup.game.map.Map;

public class Game extends BasicGame {

	Map testMap;
	float x = 450;
	float y;

	ParticleSystem particleSystem;
	Emitter emitter, emitter2, emitter3;
	BufferedImage testFont;
	Animation testanim;
	SpriteSheet testSheet;

	@Override
	public void initiate() {
		Art.init();
		testFont = Font.getFont().getLetters("PARTICLES");
		
		//animation test
		{
			testanim = new Animation();
			testSheet = new SpriteSheet("/testSpriteSheet.png", 32);
			testanim.addFrame(testSheet.getCell(0), 200);
			testanim.addFrame(testSheet.getCell(1), 200);
			testanim.addFrame(testSheet.getCell(3), 200);
			testanim.loop();
		}	
		
		// Testing
		{
			testMap = new Map("Test", 32, 32);
			particleSystem = new ParticleSystem();
			emitter = new BloodEmitter(200, 0.5F, 10);
			emitter.setLocation(-300, 250);
			particleSystem.addEmitter(emitter);
			
		}

	}

	@Override
	public void render(Graphics2D g) {
		testMap.render(g, Math.round(x), Math.round(y));
		particleSystem.render(g);
		g.drawImage(testFont, Math.round(x) + (-350), 100, testFont.getWidth(), testFont.getHeight(), null);
		g.drawImage(testanim.getImage(),30,30,null);
	}

	@Override
	public void update(int delta) {
		if (Input.getInput().isKeyDown(KeyEvent.VK_F)) {
			toggleFullScreen();
		}

		if (Input.getInput().isKeyDown(KeyEvent.VK_A)) {
			x -= 0.1F * delta;
		}

		if (Input.getInput().isKeyDown(KeyEvent.VK_D)) {
			x += 0.1F * delta;
		}

		particleSystem.update(x, y);
		testanim.update();

	}

	public static void main(String[] args) {
		Game game = new Game();
		game.createWindow();
	}

}
