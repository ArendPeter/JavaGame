import java.awt.Graphics;

public class GameObject {
	protected int x, y, width, height;
	protected int dx, dy;
	
	public GameObject(int x, int y){
		this(x,y,32,32);
	}

	public GameObject(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		dx = 0;
		dy = 0;
	}
	
	public void loop(){}

	public void draw(Graphics g){}

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
