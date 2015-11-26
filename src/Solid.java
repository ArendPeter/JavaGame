import java.awt.Color;
import java.awt.Graphics;

public class Solid extends GameObject{

	public Solid(int x, int y){
		super(x,y,64,64);
	}

	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}
}