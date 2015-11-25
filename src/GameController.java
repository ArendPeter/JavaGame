import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameController extends JPanel{

	Player player;

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
		player = new Player(10,10);
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
	}
}