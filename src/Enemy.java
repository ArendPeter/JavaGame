import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Enemy extends GameObject{

	public Enemy(int x, int y) {
		super(x,y,64,64,"enemy");
		dx = 8;
	}
	
	protected void collideWith(GameObject obj){
		if(obj instanceof Solid){
			dx = -dx;
		}
	}
}