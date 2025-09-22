package main;

import object.OBJ_gold_key;
import object.OBJ_horizontal_door;
import object.OBJ_speed_up;
import object.OBJ_vertical_door;
import object.OBJ_wood_box;
import object.house1;
import object.house2;

public class ObjectPlacement {
	GamePanel oyunPanel;
	
	public ObjectPlacement(GamePanel oyunPanel) {
		this.oyunPanel = oyunPanel;
	}
	
	public void setObject() {
		
		oyunPanel.arrOBJ[0] = new OBJ_gold_key();
		oyunPanel.arrOBJ[0].worldX = 3 * oyunPanel.tileSize;
		oyunPanel.arrOBJ[0].worldY = 21 * oyunPanel.tileSize;
		
		oyunPanel.arrOBJ[1] = new OBJ_gold_key();
		oyunPanel.arrOBJ[1].worldX = 25 * oyunPanel.tileSize;
		oyunPanel.arrOBJ[1].worldY = 27 * oyunPanel.tileSize;
		
		oyunPanel.arrOBJ[2] = new OBJ_vertical_door(oyunPanel);
		oyunPanel.arrOBJ[2].worldX = 20 * oyunPanel.tileSize;
		oyunPanel.arrOBJ[2].worldY = 26 * oyunPanel.tileSize;
		
		
		oyunPanel.arrOBJ[3] = new OBJ_horizontal_door(oyunPanel);
		oyunPanel.arrOBJ[3].worldX = 19 * oyunPanel.tileSize;
		oyunPanel.arrOBJ[3].worldY = 4 * oyunPanel.tileSize;
		
		oyunPanel.arrOBJ[4] = new OBJ_wood_box(oyunPanel);
		oyunPanel.arrOBJ[4].worldX = 35 * oyunPanel.tileSize;
		oyunPanel.arrOBJ[4].worldY = 35 * oyunPanel.tileSize;
		
		oyunPanel.arrOBJ[5] = new OBJ_speed_up(oyunPanel);
		oyunPanel.arrOBJ[5].worldX = 33 * oyunPanel.tileSize;
		oyunPanel.arrOBJ[5].worldY = 4 * oyunPanel.tileSize;
		
		oyunPanel.arrOBJ[6] = new house1(oyunPanel);
		oyunPanel.arrOBJ[6].worldX = 7 * oyunPanel.tileSize;
		oyunPanel.arrOBJ[6].worldY = 47 * oyunPanel.tileSize;
		
		oyunPanel.arrOBJ[7] = new house2(oyunPanel);
		oyunPanel.arrOBJ[7].worldX = 23 * oyunPanel.tileSize;
		oyunPanel.arrOBJ[7].worldY = 41 * oyunPanel.tileSize;
		
		oyunPanel.arrOBJ[8] = new OBJ_horizontal_door(oyunPanel);
		oyunPanel.arrOBJ[8].worldX = 26 * oyunPanel.tileSize + (oyunPanel.tileSize / 2);
		oyunPanel.arrOBJ[8].worldY = 47 * oyunPanel.tileSize;
		
	}
}
