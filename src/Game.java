
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.javagroup.game.graphics.BasicGame;
import com.javagroup.game.graphics.entity.testEnt;
import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.graphics.image.Font;
<<<<<<< HEAD
import com.javagroup.game.graphics.particle.Emitter;
import com.javagroup.game.graphics.particle.ParticleSystem;
import com.javagroup.game.graphics.particle.emitter.BloodEmitter;
=======
import com.javagroup.game.graphics.image.SpriteSheet;
import com.javagroup.game.graphics.particle.Effect;
import com.javagroup.game.graphics.particle.Effect.EffectType;
>>>>>>> 6e932999b75df71095b4700e1455ea519e252969
import com.javagroup.game.input.Input;
import com.javagroup.game.map.Map;

public class Game extends BasicGame {

	Map testMap;
	float x = 450;
	float y;

	BufferedImage testFont;
<<<<<<< HEAD
	testEnt testent;

	
=======
	Animation testanim;
	SpriteSheet testSheet;
	
	private Effect effects;
>>>>>>> 6e932999b75df71095b4700e1455ea519e252969

	@Override
	public void initiate() {
		Art.init();
		testFont = Font.getFont().getLetters("PARTICLES");
<<<<<<< HEAD
		testent = new testEnt();
=======
		effects = new Effect();
>>>>>>> 6e932999b75df71095b4700e1455ea519e252969
		

		
		// Testing
		{
			testMap = new Map("Test", 32, 32);
			Effect.playEffect(EffectType.BloodEffect, 100, 200);
			Effect.genericParticleEffect();
		}

	}

	@Override
	public void render(Graphics2D g) {
		testMap.render(g, Math.round(x), Math.round(y));
		g.drawImage(testFont, Math.round(x) + (-350), 100, testFont.getWidth(), testFont.getHeight(), null);
<<<<<<< HEAD
		testent.render(g);
=======
		g.drawImage(testanim.getImage(),30,30,null);
		effects.render(g);
>>>>>>> 6e932999b75df71095b4700e1455ea519e252969
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

<<<<<<< HEAD
		particleSystem.update(x, y);
		testent.update(delta);
=======
		testanim.update();
		effects.update(x, y);
>>>>>>> 6e932999b75df71095b4700e1455ea519e252969

	}

	public static void main(String[] args) {
		Game game = new Game();
		game.createWindow();
	}
}
