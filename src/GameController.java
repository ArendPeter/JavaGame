import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameController extends JPanel{

	int playerX = 10;
	int playerY = 10;
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Game");
		frame.setSize(800,600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		GameController panel = new GameController();
		
		frame.add(panel);	
		
		frame.setVisible(true);
	}
	
	public GameController(){
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
		playerX += 10;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(Color.ORANGE);
		g.fillRect(playerX, playerY, 50, 50);
	}
}
