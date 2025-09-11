package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_wood_box extends SuperObject{

		GamePanel oyunPanel;
	
	public OBJ_wood_box(GamePanel oyunPanel) {
		this.oyunPanel = oyunPanel;
		
		name = "wood_box";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Box1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision= true;
		
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = oyunPanel.tileSize;
		solidArea.height = oyunPanel.tileSize; 
	}
}
