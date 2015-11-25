import java.awt.Color;
import java.awt.Graphics;

public class Player {
	private int x, y;
	private int speed = 16;
	private int width= 64;
	private int height = 64;

	public Player(){
		x = 0;
		y = 0;
	}

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void loop(){
		int dx=0, dy=0;
		//keyboard input
		KeyboardController keyboard = KeyboardController.getInstance();
		if(keyboard.isUpHeld()){
			dy=-speed;
		}
		if(keyboard.isDownHeld()){
			dy=speed;
		}
		if(keyboard.isLeftHeld()){
			dx=-speed;
		}
		if(keyboard.isRightHeld()){
			dx=speed;
		}
		//check collisions
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
					dx = 0;
					dy = 0;
				}
			}
		}
		//apply velocity
		x += dx;
		y += dy;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, width, height);
	}
}
