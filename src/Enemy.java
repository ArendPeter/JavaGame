import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Enemy extends GameObject{

	public Enemy(int x, int y) {
		super(x,y,64,64);
		dx = 16;
	}
	
	public void loop(){
		ArrayList<GameObject> objs = GameController.instance.gameObjects;
	
		int myLeft = x + dx;
		int myRight = myLeft + width;
		int myTop = y + dy;
		int myBot = myTop + height;
		for(int i = 0; i < objs.size(); i++){
			int sLeft = objs.get(i).getX();
			int sRight = sLeft + objs.get(i).getWidth();
			int sTop = objs.get(i).getY();
			int sBot = sTop + objs.get(i).getHeight();
			if(myLeft < sRight && sLeft < myRight){
				if(myTop < sBot && sTop < myBot){
					if(objs.get(i) instanceof Solid){
						dx = -dx;
					}
				}
			}
		}
		x += dx;
		y += dy;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
}