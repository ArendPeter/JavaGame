import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Player extends GameObject{
	private int startX, startY;
	private int speed = 16;

	public Player(){
		this(0,0);
	}

	public Player(int x, int y) {
		super(x,y,64,64);
		startX = x;
		startY = y;
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
						dx = 0;
						dy = 0;
					}
					if(objs.get(i) instanceof Enemy){
						dx = 0;
						dy = 0;
						x = startX;
						y = startY;
					}
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
