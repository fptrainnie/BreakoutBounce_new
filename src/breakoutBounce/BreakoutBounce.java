package breakoutBounce;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class BreakoutBounce extends BasicGame{

	private Sticky stick;
	private Bounce bounce;
	
	public BreakoutBounce(String title) {
		super(title);
		
	}

	@Override
	public void render(GameContainer container, Graphics arg1) throws SlickException {
		stick.draw();
		bounce.draw();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		stick = new Sticky(200, 480);
		bounce = new Bounce(225, 400);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] arsg){
		try{
			BreakoutBounce game = new BreakoutBounce("B.O.B");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(480, 640, false);
			appgc.start();
		} catch(SlickException e){
			e.printStackTrace();
		}
	}
}
