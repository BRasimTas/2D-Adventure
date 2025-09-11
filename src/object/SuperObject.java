package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

// bu sınıf tüm objelerin süper sınıfı olacak


public class SuperObject {

	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle ();
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	
	public void draw(Graphics2D g2, GamePanel oyunPanel) {
		
		int screenX = worldX - oyunPanel.oyuncu.worldX + oyunPanel.oyuncu.screenX; 
		int screenY = worldY - oyunPanel.oyuncu.worldY + oyunPanel.oyuncu.screenY; 
		
		if (worldX  + oyunPanel.tileSize > oyunPanel.oyuncu.worldX - oyunPanel.oyuncu.screenX && 
			worldX  - oyunPanel.tileSize < oyunPanel.oyuncu.worldX + oyunPanel.oyuncu.screenX &&
			worldY  + oyunPanel.tileSize > oyunPanel.oyuncu.worldY - oyunPanel.oyuncu.screenY &&
			worldY  - oyunPanel.tileSize < oyunPanel.oyuncu.worldY + oyunPanel.oyuncu.screenY ) {
			
		g2.drawImage(image, screenX,screenY,oyunPanel.tileSize,oyunPanel.tileSize, null);
		
	
		}
	}
}
