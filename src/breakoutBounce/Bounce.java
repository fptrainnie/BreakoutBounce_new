package breakoutBounce;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bounce {
	private Sticky stick;
	//private CheckCollision check;
	
	private Image image;
	private float x;
	private float y;
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
		x+= vx;
		checkBlock();

	}
	
	public void newMoveDirective (){
		vy *= -1 ;
	}
	
	public void newMoveLeft (){
		vx=-1;
		vy *= -1 ;
	}
	
	public void newMoveRight (){
		vx=1;
		vy *= -1 ;
	}
	
	public void checkBlock(){
		if (y<0) vy*=-1; 
		if (x<0) vx*=-1;
		if (x>450) vx*=-1;
	}
	
	 
	
	
}
