import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameController extends JFrame {
	
	JPanel p = new JPanel();
	
	public static void main(String[] args) {
		new GameController();
	}
	
	public GameController(){
		super("Game");
		setSize(800,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		add(p);
		
		setVisible(true);
	}

}
