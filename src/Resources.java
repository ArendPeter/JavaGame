import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Resources {
	private static Resources instance;

	private HashMap<String,BufferedImage> images;
	
	public static Resources getInstance(){
		if(instance == null){
			instance = new Resources();
		}
		return instance;
	}
	
	private Resources(){
		images = new HashMap<String,BufferedImage>();
	}
	
	public BufferedImage getImage(String imgName){
		if(!images.containsKey(imgName)){
			loadImage(imgName);
		}
		return images.get(imgName);
	}
	
	private void loadImage(String imgName){
		BufferedImage img;
		try{
			img = ImageIO.read(new File("img/"+imgName+".png"));
			images.put(imgName,img);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
