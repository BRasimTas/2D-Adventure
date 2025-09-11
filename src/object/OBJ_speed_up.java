package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_speed_up extends SuperObject{
	public OBJ_speed_up(GamePanel oyunPanel) {
		name = "speed_up";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/speed_potion.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		solidArea.x = 6;
		solidArea.y = 0;
		solidArea.width = oyunPanel.tileSize / 4 ;
		solidArea.height = oyunPanel.tileSize; 
	
	
	}
}
		
		

