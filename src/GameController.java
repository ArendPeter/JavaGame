import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameController extends JPanel{

	KeyboardController keyboard;

	short playerX = 20;
	short playerY = 20;
	int speed = 10;
	
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
		keyboard = new KeyboardController();
		this.addKeyListener(keyboard);
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
		if(keyboard.isUpHeld()){
			playerY-=speed;
		}
		if(keyboard.isDownHeld()){
			playerY+=speed;
		}
		if(keyboard.isLeftHeld()){
			playerX-=speed;
		}
		if(keyboard.isRightHeld()){
			playerX+=speed;
		}
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