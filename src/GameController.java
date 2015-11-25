import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameController extends JPanel{

	public static GameController instance;

	Player player;
	Solid[] solids;

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
		player = new Player(64,64);
		solids = new Solid[5];
		solids[0] = new Solid(128,128);
		solids[1] = new Solid(64,256);
		solids[2] = new Solid(128,256);
		solids[3] = new Solid(256,64);
		solids[4] = new Solid(256,512);
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
		player.loop();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		//fill background
		g.setColor(Color.WHITE);
		g.fillRect(0,0,getWidth(),getHeight());

		player.draw(g);
		for(int i = 0; i < solids.length; i++){
			solids[i].draw(g);
		}
	}
}