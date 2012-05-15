import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.javagroup.game.entity.Limb;
import com.javagroup.game.graphics.animation.Animation;
import com.javagroup.game.graphics.image.SpriteSheet;
import com.javagroup.game.input.Input;


public class TestLimb extends Limb{
	
	private SpriteSheet sheet;
	
	private Animation sword;
	
	public TestLimb(){
		sheet = new SpriteSheet("/swordright.png", 32);
		setX(20);
		{
			sword = new Animation();
			sword.addFrame(sheet.getCell(0), 150);
			sword.addFrame(sheet.getCell(1), 150);
			sword.addFrame(sheet.getCell(2), 150);
			sword.loop();
		
		}
	}

	@Override
	public void render(Graphics2D g, float xoff, float yoff) {
		g.drawImage(sword.getImage(),Math.round(getX()+xoff),Math.round(getY()+yoff),null);
		
	}

	@Override
	public void update(long delta) {
		sword.update();
		
		
		if(Input.getInput().isKeyDown(KeyEvent.VK_A)){
			setX(-10);
		}
		
		if(Input.getInput().isKeyDown(KeyEvent.VK_D)){
			setX(20);
		}
		
	}

}
