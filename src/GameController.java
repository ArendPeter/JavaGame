import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameController extends JPanel{

	public static GameController instance;

	Player player;
	Solid[] solids;
	Enemy enemy;
	ArrayList<GameObject> gameObjects;

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

		gameObjects = new ArrayList<GameObject>();

		gameObjects.add(new Player(64,64));

		gameObjects.add(new Solid(128,128));
		gameObjects.add(new Solid(64,256));
		gameObjects.add(new Solid(512,256));
		gameObjects.add(new Solid(256,64));
		gameObjects.add(new Solid(256,512));
		
		gameObjects.add(new Enemy(128,256));
		
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
		for(int i = 0; i < gameObjects.size(); i++){
			gameObjects.get(i).loop();
		}
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		//fill background
		g.setColor(Color.WHITE);
		g.fillRect(0,0,getWidth(),getHeight());

		for(int i = 0; i < gameObjects.size(); i++){
			gameObjects.get(i).draw(g);
		}
	}
}