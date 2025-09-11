package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_vertical_door extends SuperObject{
	
		GamePanel oyunPanel;
		
	public OBJ_vertical_door(GamePanel oyunPanel) {
		this.oyunPanel = oyunPanel;
		
		name = "vertical_door";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/vertical_door.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
		
		solidArea.x = 5;
		solidArea.y = 0;
		solidArea.width = 6;
		solidArea.height = oyunPanel.tileSize; 
	}

}
