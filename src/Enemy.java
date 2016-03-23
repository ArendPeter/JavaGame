import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Enemy extends GameObject{

	public Enemy(int x, int y) {
		super(x,y,64,64);
		dx = 8;
	}
	
	protected void collideWith(GameObject obj){
		if(obj instanceof Solid){
			dx = -dx;
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
}