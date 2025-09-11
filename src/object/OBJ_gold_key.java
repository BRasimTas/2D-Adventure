package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_gold_key extends SuperObject{
	
	public OBJ_gold_key() {
		name = "gold_key";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Gold_key1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		solidArea.x = 7;
		solidArea.y = 7;
		solidArea.width = 34;
		solidArea.height = 34;
		
		
		
	}

}
