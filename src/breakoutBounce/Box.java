package breakoutBounce;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Box {
	float x;
	float y;
	private Image box;
	public Box(float x, float y) throws SlickException{
		this.x = x;
		this.y = y;
		box = new Image("res/box.png");
	}
	
	public void render(){
		box.draw(x,y);
	}
	public void update() {
		
	}
}
