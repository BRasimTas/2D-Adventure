package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_horizontal_door extends SuperObject {
	GamePanel oyunPanel;
	
	public OBJ_horizontal_door(GamePanel oyunPanel) {
		this.oyunPanel = oyunPanel;
		
		name = "horizontal_door";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/horizontal_door.png"));
		} catch (IOException e){
			e.printStackTrace();
		}
		
		collision = true;
		
		solidArea.x = 5;
		solidArea.y = 0;
		solidArea.width = 30;
		solidArea.height = oyunPanel.tileSize;
	}
}
