import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameController extends JPanel implements KeyListener{

	short playerX = 20;
	short playerY = 20;
	int speed = 10;
	
	boolean leftHeld = false;
	boolean rightHeld = false;
	boolean upHeld = false;
	boolean downHeld = false;
	
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
		this.addKeyListener(this);
		setFocusable(true);
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
		if(upHeld){
			playerY-=speed;
		}
		if(downHeld){
			playerY+=speed;
		}
		if(leftHeld){
			playerX-=speed;
		}
		if(rightHeld){
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

	@Override
	public void keyPressed(KeyEvent e) {
	  switch(e.getKeyCode())	{
	  case KeyEvent.VK_UP: upHeld = true; break;
	  case KeyEvent.VK_DOWN: downHeld = true; break; 
	  case KeyEvent.VK_LEFT: leftHeld = true; break; 
	  case KeyEvent.VK_RIGHT: rightHeld = true; break; 
	  }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode())	{
		  case KeyEvent.VK_UP: upHeld = false; break;
		  case KeyEvent.VK_DOWN: downHeld = false; break; 
		  case KeyEvent.VK_LEFT: leftHeld = false; break; 
		  case KeyEvent.VK_RIGHT: rightHeld = false; break; 
	  }
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}
