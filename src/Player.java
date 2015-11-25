import java.awt.Color;
import java.awt.Graphics;

public class Player {
	private int x, y;
	private int speed = 10;

	public Player(){
		x = 0;
		y = 0;
	}

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void loop(){
		KeyboardController keyboard = KeyboardController.getInstance();
		if(keyboard.isUpHeld()){
			y-=speed;
		}
		if(keyboard.isDownHeld()){
			y+=speed;
		}
		if(keyboard.isLeftHeld()){
			x-=speed;
		}
		if(keyboard.isRightHeld()){
			x+=speed;
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 50, 50);
	}
}
