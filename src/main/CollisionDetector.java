package main;

import entity.Entity;

public class CollisionDetector {
	
	GamePanel oyunPanel;
	
	public CollisionDetector(GamePanel gp) {
		this.oyunPanel = gp;
	}
	
	public void checkTile (Entity entity) {
		
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
	
		int entityLeftCol = 	entityLeftWorldX / oyunPanel.tileSize;
		int entityRightCol = entityRightWorldX / oyunPanel.tileSize;
		int entityTopRow = entityTopWorldY/oyunPanel.tileSize;
		int entityBottomRow = entityBottomWorldY/oyunPanel.tileSize;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		
		case "up":
			
			entityTopRow = (entityTopWorldY - entity.speed) / oyunPanel.tileSize;
			tileNum1 = oyunPanel.karoM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = oyunPanel.karoM.mapTileNum[entityRightCol][entityTopRow];

			if(oyunPanel.karoM.tile[tileNum1].collision == true || oyunPanel.karoM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
			
		case "down":
			
			entityBottomRow = (entityBottomWorldY + entity.speed) / oyunPanel.tileSize;
			tileNum1 = oyunPanel.karoM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = oyunPanel.karoM.mapTileNum[entityRightCol][entityBottomRow];
			
			if (oyunPanel.karoM.tile[tileNum1].collision == true || oyunPanel.karoM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
			
		case "left":
			
			entityLeftCol = (entityLeftWorldX - entity.speed) / oyunPanel.tileSize;
			tileNum1 = oyunPanel.karoM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = oyunPanel.karoM.mapTileNum[entityLeftCol][entityBottomRow];
			
			if (oyunPanel.karoM.tile[tileNum1].collision == true || oyunPanel.karoM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
			
		case "right":
			
			entityRightCol = (entityRightWorldX + entity.speed) / oyunPanel.tileSize;
			tileNum1 = oyunPanel.karoM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = oyunPanel.karoM.mapTileNum[entityRightCol][entityBottomRow];
			
			if (oyunPanel.karoM.tile[tileNum1].collision == true || oyunPanel.karoM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		
		}	
	
	}
	public int checkObject(Entity entity, boolean player) {
		
		int index = 999;
		
		for (int i = 0; i < oyunPanel.arrOBJ.length; i++) {
			if (oyunPanel.arrOBJ[i] != null ) {
				
				// entity'in katı alanını hazırlayıyoruz
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				// istediğimiz nesnenin katı alanını hesaplayalım
				oyunPanel.arrOBJ[i].solidArea.x = oyunPanel.arrOBJ[i].worldX + oyunPanel.arrOBJ[i].solidArea.x; 
				oyunPanel.arrOBJ[i].solidArea.y = oyunPanel.arrOBJ[i].worldY + oyunPanel.arrOBJ[i].solidArea.y;
				
				
				switch (entity.direction) {
				case "up":
						entity.solidArea.y -= entity.speed;
						if(entity.solidArea.intersects(oyunPanel.arrOBJ[i].solidArea)) {
						//	System.out.println("top collision");
							
							if (oyunPanel.arrOBJ[i].collision == true) {
								entity.collisionOn = true;
							}
							
							if (player == true) {
								index = i;
							}
						}
						
					break;
					
				case "down":
						entity.solidArea.y += entity.speed;
						if(entity.solidArea.intersects(oyunPanel.arrOBJ[i].solidArea)) {
						//	System.out.println("bottom collision");
							if (oyunPanel.arrOBJ[i].collision == true) {
								entity.collisionOn = true;
							}
							
							if (player == true) {
								index = i;
							}
						}
					break;
					
				case "left":
						entity.solidArea.x -= entity.speed;
						if(entity.solidArea.intersects(oyunPanel.arrOBJ[i].solidArea)) {
						//	System.out.println("left collision");
							if (oyunPanel.arrOBJ[i].collision == true) {
								entity.collisionOn = true;
							}
							
							if (player == true) {
								index = i;
							}
						}
					break;
					
				case "right":
						entity.solidArea.x += entity.speed;
						if(entity.solidArea.intersects(oyunPanel.arrOBJ[i].solidArea)) {
							if (oyunPanel.arrOBJ[i].collision == true) {
								entity.collisionOn = true;
							}
							
							if (player == true) {
								index = i;
							}
						
						}
					break;
				}
			
			
			entity.solidArea.x = entity.solidAreaDefaultX;
			entity.solidArea.y = entity.solidAreaDefaultY;
			
			oyunPanel.arrOBJ[i].solidArea.x = oyunPanel.arrOBJ[i].solidAreaDefaultX;
			oyunPanel.arrOBJ[i].solidArea.y = oyunPanel.arrOBJ[i].solidAreaDefaultY;
		}
	
		
		
	}
		return index;
	}
	
}
	
	
	
	
	

