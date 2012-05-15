
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.javagroup.game.graphics.BasicGame;
import com.javagroup.game.graphics.image.Art;
import com.javagroup.game.graphics.image.Font;
import com.javagroup.game.graphics.particle.Effect;
import com.javagroup.game.graphics.particle.Effect.EffectType;
import com.javagroup.game.input.Input;
import com.javagroup.game.map.Map;

public class Game extends BasicGame {

	Map testMap;
	float x = 450;
	float y;

	BufferedImage testFont;
	testEnt testent;

	private Effect effect;
	

	@Override
	public void initiate() {
		Art.init();
		testFont = Font.getFont().getLetters("PARTICLES");
		effect = new Effect();
		

		
		// Testing
		{
			testent = new testEnt();
			testMap = new Map("Test", 32, 32);

			Effect.playEffect(EffectType.BloodEffect, 100, 200);
			Effect.genericParticleEffect();

		}

	}

	@Override
	public void render(Graphics2D g) {
		testMap.render(g, Math.round(x), Math.round(y));
		g.drawImage(testFont, Math.round(x) + (-350), 100, testFont.getWidth(), testFont.getHeight(), null);
		testent.render(g);
		effect.render(g);
	}

	@Override
	public void update(int delta) {
		if (Input.getInput().isKeyDown(KeyEvent.VK_F)) {
			toggleFullScreen();
		}

		if (Input.getInput().isKeyDown(KeyEvent.VK_A)) {
			x += 0.1F * delta;
		}

		if (Input.getInput().isKeyDown(KeyEvent.VK_D)) {
			x -= 0.1F * delta;
		}
		if (Input.getInput().isKeyDown(KeyEvent.VK_W)) {
			y += 0.1F * delta;
		}

		if (Input.getInput().isKeyDown(KeyEvent.VK_S)) {
			y -= 0.1F * delta;
		}

		testent.update(delta);
		effect.update(x, y);
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.createWindow();
	}

}
