import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
	private int x, y;
	private int width = 64;
	private int height = 64;

	private int dx=0, dy=0;

	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		dx = 16;
	}
	
	public void loop(){
		Solid[] solids = GameController.instance.solids;
		int myLeft = x + dx;
		int myRight = myLeft + width;
		int myTop = y + dy;
		int myBot = myTop + height;
		for(int i = 0; i < solids.length; i++){
			int sLeft = solids[i].getX();
			int sRight = sLeft + solids[i].getWidth();
			int sTop = solids[i].getY();
			int sBot = sTop + solids[i].getHeight();
			if(myLeft < sRight && sLeft < myRight){
				if(myTop < sBot && sTop < myBot){
					dx = -dx;
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
