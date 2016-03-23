import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Player extends GameObject{
	private int startX, startY;
	private int speed = 16;
	private int points = 0;

	public Player(){
		this(0,0);
	}

	public Player(int x, int y) {
		super(x,y,64,64);
		startX = x;
		startY = y;
	}

	public void loop(){
		dx = 0;
		dy = 0;
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
	}
	
	protected void collideWith(GameObject obj){
		if(obj instanceof Solid){
			dx = 0;
			dy = 0;
		}
		if(obj instanceof Enemy){
			dx = 0;
			dy = 0;
			rect.x = startX;
			rect.y = startY;
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
		g.setColor(Color.WHITE);
		g.drawString(points+"", (int)rect.getCenterX(), 
			(int)rect.getCenterY());
	}
	
	public void gainPoint(){
		points++;
	}
}
