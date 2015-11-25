import java.awt.Color;
import java.awt.Graphics;

public class Solid {
	private int x,y;
	private int width = 64;
	private int height = 64;

	public Solid(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
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
