import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Player extends GameObject{
	private int startX, startY;
	private int speed = 16;
	private int points = 0;

	private float frame = 0;
	private int numFrames = 10;
	private float frameSpeed = .2f;

	public Player(){
		this(0,0);
	}

	public Player(int x, int y) {
		super(x,y,64,64,"player_anim");
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
		
		if(dx != 0 || dy != 0){
			frame+=frameSpeed;
			if(frame > numFrames){
				frame -= numFrames;
			}
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
		g.drawImage(Resources.getInstance().getImage(imgName), 
			(int)rect.getMinX(), (int)rect.getMinY(), 
			(int)rect.getMaxX(), (int)rect.getMaxY(), 
			(int)frame * (int)rect.getWidth(), 0,
			((int)frame+1) * (int)rect.getWidth(), (int)rect.getHeight(),
			null);
		g.setColor(Color.BLACK);
		g.drawString(points+"", 80, 80);
	}
	
	public void gainPoint(){
		points++;
	}
}
