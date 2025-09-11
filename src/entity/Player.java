package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel oyunPanel;
	KeyHandler tuslar;
	
	public final int screenX;
	public final int screenY;
	public int hasGoldKey = 0;
	
	
	public Player(GamePanel gp, KeyHandler tuslar) {
		this.oyunPanel = gp;
		this.tuslar = tuslar;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 12;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 24;
		solidArea.height = 30;
		
		
		
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		worldX = oyunPanel.tileSize * 22;
		worldY = oyunPanel.tileSize * 16;
		
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/Player/player_behind_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/Player/player_behind_2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/Player/player_behind_3.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/Player/player_front_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/Player/player_front_2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/Player/player_front_3.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/Player/player_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/Player/player_left_2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/Player/player_left_3.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/Player/player_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/Player/player_right1_2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/Player/player_right_3.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		
//
		//
		// karakterin yöünü ve daha sonra o yönde yürümesini sağlıyoruz.
		//
		
		if(tuslar.upPress == true || tuslar.downPress == true || 
				tuslar.leftPress == true || tuslar.rightPress == true) {
		
		if(tuslar.upPress == true) {
			direction = "up";
//			worldY -= speed;
		}
		else if (tuslar.downPress == true) {
			direction = "down";
//			worldY += speed;
		}
		else if (tuslar.leftPress == true) {
			direction = "left";
//			worldX -= speed;
		}
		else if (tuslar.rightPress == true) {
			direction = "right";
//			worldX += speed;
		}
		
		
		//
		//   yer karolarına çarpacak mı içinden mi geçecek.
		//
		collisionOn = false;
		oyunPanel.CD.checkTile(this);
		
		
		//
		//oyuncuyu nesnelere göre çarpışmasını kıyasla
		// bazı nesneler envantere gelecek ve bazıları parçalanacak.
		//
		int objIndex = oyunPanel.CD.checkObject(this,true);
		pickUpObject(objIndex);
		//
		//  eğer çarpışma yoksa oyuncu istediği gibi hareket edecek
		//	eğer çarpışma saptanırsa oyuncu durdurulacak.
		//
		
			if (collisionOn == false) {
				switch(direction) {
				
				case "up":
					worldY -= speed;
					break;
					
				case "down":
					worldY += speed;
					break;
					
				case "left":
					worldX -= speed;
					break;
					
				case "right":
					worldX += speed;
					break;
				
				
				}
			}
	
		spriteCounter++;
	 if( spriteCounter > 10 ) {
			if (spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 3;
			}
			else if (spriteNum == 3) {
				spriteNum = 1;
			}
			spriteCounter = 0;
			
	 	}
	  }
	
	}
	public void pickUpObject(int i) {
		
		if (i != 999) {
			
				String objectName = oyunPanel.arrOBJ[i].name;
				
				
			//	System.out.println("bu koda ulaşıyor mu");
				
				switch (objectName) {
				
				case "gold_key":
					hasGoldKey++;
					oyunPanel.arrOBJ[i] = null;
				//	System.out.println("altın anahtar miktarı: " + hasGoldKey);
					oyunPanel.playSE(1);
				//	System.out.println("ses kaç defa çalıoyr");
					oyunPanel.ui.showMessage("Gold Key obtained!");
					
					break;
				
				case "vertical_door":
					if (hasGoldKey > 0) {
					oyunPanel.arrOBJ[i] = null;
					hasGoldKey--;
					oyunPanel.playSE(3);
					oyunPanel.ui.showMessage("Gold Door unlocked!");
					System.out.println("altın anahtar miktarı :" + hasGoldKey);
					} else {
						oyunPanel.ui.showMessage("No Gold Key");
					}
				
					
					break;
					
				case "wood_box":
							oyunPanel.ui.gameFinished = true;
								oyunPanel.stopMusic();
								oyunPanel.playSE(2);
								oyunPanel.playMusic(4);
					break;
					
				case "speed_up":
					speed += 2;
					oyunPanel.arrOBJ[i] = null;
					oyunPanel.ui.showMessage("Speed boost +1");
					oyunPanel.playSE(1);
					break;
				
					
					
		//		case "Chest":
		//			oyunPanel.ui.gameFinished = true;
		//			oyunPanel.stopMusic();
		//			oyunPanel.playSE(2);
		//			break;
				//default:
					
					//break;
				}
		}
	}
	
	
	public void draw(Graphics2D g2) {
	
		BufferedImage image = null;
		
		switch(direction) {
		
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			if(spriteNum == 3) {
				image = up3;
			}break;
			
			
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			if(spriteNum == 3) {
				image = down3;
			}	break;
			
			
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			if(spriteNum == 3) {
				image = left3;
			}break;
			
			
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			if(spriteNum == 3) {
				image = right3;
			}break;
			
			
		}
		
		g2.drawImage(image, screenX, screenY, oyunPanel.tileSize, oyunPanel.tileSize, null);
		
		
	}
}
