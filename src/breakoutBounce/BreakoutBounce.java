package breakoutBounce;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class BreakoutBounce extends BasicGame{

	private Sticky stick;
	private Bounce bounce;
	
	public static final int GAME_WIDTH = 480;
	  public static final int GAME_HEIGHT = 640;
	
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
		bounce = new Bounce(GAME_WIDTH/2-15, GAME_HEIGHT*40/64,10);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		updateStickMovement(input, delta);
		bounce.update();
	}
	
	void updateStickMovement(Input input, int delta){
		if(input.isKeyDown(Input.KEY_LEFT)) {
			stick.moveLeft();
		}
		if(input.isKeyDown(Input.KEY_RIGHT)) {
			stick.moveRight();
		}
	}
	
	public static void main(String[] arsg){
		try{
			BreakoutBounce game = new BreakoutBounce("B.O.B");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
			appgc.setMinimumLogicUpdateInterval(1000 / 60);
			appgc.start();
		} catch(SlickException e){
			e.printStackTrace();
		}
	}
}
