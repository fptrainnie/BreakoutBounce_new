package breakoutBounce;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class BreakoutBounce extends BasicGame{

	private Sticky stick;
	private Bounce bounce;
	private ArrayList<Box> boxs = new ArrayList<Box>();
	private int score = 0;
	
	public static final int GAME_WIDTH = 480;
	  public static final int GAME_HEIGHT = 640;
	  
	  public void stick() {
		
			if(bounce.getY() == 450 ) {
				
				if (bounce.getX()+15 == stick.getX()+ 40){
					bounce.newMoveDirective();
				}
				else if ( bounce.getX()+15 < stick.getX()+ 20 && (Math.abs(bounce.getX()+15 - (stick.getX()+ 40)) < 40+15 )){
					bounce.newMoveLeft1();
				}
				else if ( bounce.getX()+15 < stick.getX()+ 30 && (Math.abs(bounce.getX()+15 - (stick.getX()+ 40)) < 40+15 )){
					bounce.newMoveLeft2();
				}
				else if ( bounce.getX()+15 < stick.getX()+ 40 && (Math.abs(bounce.getX()+15 - (stick.getX()+ 40)) < 40+15 )){
					bounce.newMoveLeft3();
				}
				else if (bounce.getX()+15 > stick.getX()+ 40 && (Math.abs(bounce.getX()+15 - (stick.getX()+ 40)) < 40+15 )){
					bounce.newMoveRight1();
				}
				else if (bounce.getX()+15 > stick.getX()+ 30 && (Math.abs(bounce.getX()+15 - (stick.getX()+ 40)) < 40+15 )){
					bounce.newMoveRight2();
				}
				else if (bounce.getX()+15 > stick.getX()+ 20 && (Math.abs(bounce.getX()+15 - (stick.getX()+ 40)) < 40+15 )){
					bounce.newMoveRight3();
				}
		}
	  }
	  
	public BreakoutBounce(String title) {
		super(title);
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		for(Box box : boxs){
			box.render();
		}
		stick.draw();
		bounce.draw();
		
		g.drawString("Score : " + score, 370, 620);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		stick = new Sticky(200, 480);
		bounce = new Bounce(GAME_WIDTH/2-15, GAME_HEIGHT*40/64, 0,2);
		for(int i=0;i<24;i++){
			for(int j=0;j<7;j++){
				boxs.add(new Box(i*40,j*40));
			}
		}
	}
	

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		updateStickMovement(input, delta);
		bounce.update();
		stick();
		
		for(Box box : boxs){
			box.update();
		}
		
		for(int i=0;i<boxs.size();i++){
			if(boxs.get(i).isCollide(Bounce.getBx(), Bounce.getBy())){
				boxs.remove(i);
				score++;
			}
		}
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
