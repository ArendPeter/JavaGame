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
	
	private int blockWidth = 64;
	private int blockHeight = 64;
	private char[][] lvl = {//'p', '-', 's', 'e', 'c'
		{'s','s','s','s','s','s','s','s','s','s','s','s'},
		{'s','-','-','-','-','-','-','-','-','-','-','s'},
		{'s','-','-','p','-','s','-','c','-','-','-','s'},
		{'s','-','-','-','-','-','-','-','-','-','-','s'},
		{'s','-','s','-','-','e','-','-','-','s','-','s'},
		{'s','-','-','-','-','-','-','-','-','-','-','s'},
		{'s','-','-','c','-','s','-','c','-','-','-','s'},
		{'s','-','-','-','-','-','-','-','-','-','-','s'},
		{'s','s','s','s','s','s','s','s','s','s','s','s'},
	};

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
		initVariables();
		loadLevel();
		startGame();
	}
	
	private void initVariables(){
		instance = this;
		objects = new HashMap<Integer,GameObject>();
		objectsToDelete = new ArrayList<GameObject>();
		this.addKeyListener(KeyboardController.getInstance());
	}
	
	private void loadLevel(){
		for(int i = 0; i < lvl.length; i++){
			for(int j = 0; j < lvl[i].length; j++){
				int x = j * blockWidth;
				int y = i * blockHeight;
				switch(lvl[i][j]){
				case '-': break;
				case 's': addObject(new Solid(x,y)); break;
				case 'p': addObject(new Player(x,y)); break;
				case 'c': addObject(new Coin(x,y)); break;
				case 'e': addObject(new Enemy(x,y)); break;
				}
			}
		}
	}
	
	private void startGame(){
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

		for(GameObject obj : objects.values()){
			obj.draw(g);
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