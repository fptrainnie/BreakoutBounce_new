package breakoutBounce;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bounce {
	private Image image;
	private float x;
	private float y;
	private float vy;
	
	public Bounce(float x, float y, float vy) throws SlickException {
		image = new Image("res/bb.png");
		this.x = x;
		this.y = y;
		this.vy = vy;
	}
	
	public void draw() {
		image.draw(x, y);
	}

	public void update() {
		y += vy;
		vy -= 0.1;
	}
}
