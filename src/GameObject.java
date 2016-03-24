import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class GameObject {
	protected Rectangle rect;
	protected int dx, dy;
	protected int id;
	protected String imgName;
	
	protected static int next_id = 0;
	
	public GameObject(int x, int y){
		this(x,y,32,32,"");
	}

	public GameObject(int x, int y, int width, int height){
		this(x,y,width,height,"");
	}

	public GameObject(int x, int y, int width, int height, String imgName){
		rect = new Rectangle(x,y,width,height);
		dx = 0;
		dy = 0;
		id = getNewId();
		this.imgName = imgName;
	}
	
	public void loop(){}

	public void checkCollisions(){
		for(GameObject obj : GameController.instance.getObjects()){
			if(obj==this){
				continue;
			}
			if(rectOverlap(rect,obj.getRect())){
				collideWith(obj);
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

	public void draw(Graphics g){
		if(imgName != ""){
			g.drawImage(Resources.getInstance().getImage(imgName), 
				rect.x, rect.y, null);
		}
	}

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
	
	protected static int getNewId(){
		return next_id++;
	}
	
	public int getId(){
		return id;
	}
	
	protected void delete(){
		GameController.instance.removeObject(this);
	}
}
