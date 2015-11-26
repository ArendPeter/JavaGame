import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class GameObject {
	protected Rectangle rect;
	protected int dx, dy;
	
	public GameObject(int x, int y){
		this(x,y,32,32);
	}

	public GameObject(int x, int y, int width, int height){
		rect = new Rectangle(x,y,width,height);
		dx = 0;
		dy = 0;
	}
	
	public void loop(){}

	public void checkCollisions(){
		ArrayList<GameObject> objs = GameController.instance.gameObjects;
		for(int i = 0; i < objs.size(); i++){
			if(objs.get(i)==this){
				continue;
			}
			if(rectOverlap(rect,objs.get(i).getRect())){
				collideWith(objs.get(i));
			}
		}

	}
	
	protected boolean rectOverlap(Rectangle r1, Rectangle r2){
		boolean xOverlap = r1.getMinX()+dx < r2.getMaxX() && r2.getMinX() < r1.getMaxX()+dx;
		boolean yOverlap = r1.getMinY()+dy < r2.getMaxY() && r2.getMinY() < r1.getMaxY()+dy;
		return xOverlap && yOverlap;
	}

	protected void collideWith(GameObject obj){}

	public void applyMovement(){
		rect.x += dx;
		rect.y += dy;
	}

	public void draw(Graphics g){}

	public int getX() {
		return (int) rect.x;
	}

	public int getY() {
		return (int) rect.y;
	}

	public int getWidth() {
		return (int) rect.width;
	}

	public int getHeight() {
		return (int) rect.height;
	}

	public Rectangle getRect() {
		return rect;
	}
}
