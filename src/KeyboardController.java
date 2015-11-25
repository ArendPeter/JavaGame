import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements KeyListener {

	private boolean leftHeld = false;
	private boolean rightHeld = false;
	private boolean upHeld = false;
	private boolean downHeld = false;
	
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
	
	public boolean isUpHeld(){
		return upHeld;
	}
	
	public boolean isDownHeld(){
		return downHeld;
	}

	public boolean isLeftHeld() {
		return leftHeld;
	}

	public boolean isRightHeld() {
		return rightHeld;
	}
}
