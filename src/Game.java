import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.javagroup.game.graphics.BasicGame;
import com.javagroup.game.graphics.animation.Animation;
import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.graphics.image.Font;
import com.javagroup.game.graphics.image.SpriteSheet;
import com.javagroup.game.graphics.particle.Effect;
import com.javagroup.game.graphics.particle.Effect.EffectType;
import com.javagroup.game.input.Input;
import com.javagroup.game.map.Map;

public class Game extends BasicGame {

	Map testMap;
	float x = 450;
	float y;

	BufferedImage testFont;
	Animation testanim;
	SpriteSheet testSheet;
	
	private Effect effects;

	@Override
	public void initiate() {
		Art.init();
		testFont = Font.getFont().getLetters("PARTICLES");
		effects = new Effect();
		
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
			Effect.playEffect(EffectType.BloodEffect, 100, 200);
			Effect.genericParticleEffect();
		}

	}

	@Override
	public void render(Graphics2D g) {
		testMap.render(g, Math.round(x), Math.round(y));
		g.drawImage(testFont, Math.round(x) + (-350), 100, testFont.getWidth(), testFont.getHeight(), null);
		g.drawImage(testanim.getImage(),30,30,null);
		effects.render(g);
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

		testanim.update();
		effects.update(x, y);

	}

	public static void main(String[] args) {
		Game game = new Game();
		game.createWindow();
	}
}
