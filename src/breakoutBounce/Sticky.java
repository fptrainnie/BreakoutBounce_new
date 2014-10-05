package breakoutBounce;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Sticky {
	private Image image;
	private int x;
	private int y;
	
	//private CheckCollision check;
	
	public Sticky(int x, int y) throws SlickException {
		image = new Image("res/stick.png");
		this.x = x;
		this.y = y;
	}
	
	public void draw() {
		image.draw(x, y);
	}
	
	public void moveLeft() {
		if(x>0) {
			x--;
		}
	}
	
	public void moveRight() {
		if(x<400) {
			x++;
		}
	}
	
	public void getstick(float x_bounce) {
		System.out.println("C");
		float x_stick = this.x;
		//check.stick(x_bounce, x_stick);
	}
	public float getX(){
		return this.x ;
	}
	public float getY(){
		return this.y ;
	}
	
}
