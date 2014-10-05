package breakoutBounce;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bounce {
	private Sticky stick;
	//private CheckCollision check;
	
	private Image image;
	private static float x;
	private static float y;
	private float vy;
	private float vx;
	
	public float getX(){
		return this.x ;
	}
	public float getY(){
		return this.y ;
	}
	public Bounce(float x, float y, float vx, float vy) throws SlickException {
		image = new Image("res/bb.png");
		this.x = x;
		this.y = y;
		this.vy = vy;
		this.vx = vx;
	}
	
	public void draw() {
		image.draw(x, y);
	}

	public void update() {
		y += vy;
		x += vx;
		checkBlock();

	}
	
	public static float getBx(){
		return x;
	}
	public static float getBy(){
		return y;
	}
	
	public void newMoveDirective (){
		vy *= -1 ;
	}
	
	public void newMoveLeft1 (){
		vx =-2;
		vy *= -1 ;
	}
	
	public void newMoveLeft2 (){
		vx =-1;
		vy *= -1 ;
	}
	
	public void newMoveRight1 (){
		vx = 1;
		vy *= -1 ;
	}	
	public void newMoveRight2 (){
		vx = 10;
		vy *= -1 ;
	}
	
	public void checkBlock(){
		if (y<0) vy*=-1; 
		if (x<0) vx*=-1;
		if (x>450) vx*=-1;
	}
	
	 
	
	
}
