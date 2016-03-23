import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameController extends JPanel{

	public static GameController instance;

	private HashMap<Integer,GameObject> objects;
	private ArrayList<GameObject> objectsToDelete;

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Game");
		frame.setSize(800,600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		
		GameController panel = new GameController();
		
		frame.add(panel);	
		
		frame.setVisible(true);

	    panel.requestFocus();	
	}
	
	public GameController(){
		instance = this;

		objects = new HashMap<Integer,GameObject>();
		objectsToDelete = new ArrayList<GameObject>();

		addObject(new Player(64,64));

		addObject(new Solid(64,256));
		addObject(new Solid(512,256));
		addObject(new Solid(256,64));
		addObject(new Solid(256,512));
		
		addObject(new Enemy(128,256));
		
		addObject(new Coin(128,128));
		
		this.addKeyListener(KeyboardController.getInstance());
		new Thread(){
		  public void run(){
			try{
				while(true){
					gameLoop();
					Thread.sleep(33);
				}
			}catch(Exception e){
				e.printStackTrace();
			}  
		  }
		}.start();
	}
	
	private void gameLoop(){
		for(GameObject obj : objects.values()){
			obj.loop();
			obj.checkCollisions();
			obj.applyMovement();
		}
		
		for(GameObject obj : objectsToDelete){
			objects.remove(obj.getId());
		}
		objectsToDelete.clear();

		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		//fill background
		g.setColor(Color.WHITE);
		g.fillRect(0,0,getWidth(),getHeight());

		for(int i = 0; i < objects.size(); i++){
			objects.get(i).draw(g);
		}
	}
	
	public Collection<GameObject> getObjects(){
		return objects.values();
	}
	
	private void addObject(GameObject obj){
		objects.put(obj.getId(), obj);
	}
	
	public void removeObject(GameObject obj){
		objectsToDelete.add(obj);
	}
}