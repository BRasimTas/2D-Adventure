package object;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class house2 extends SuperObject{
	 GamePanel oyunPanel;
	    final int scale = 3; // Scale factor used throughout the game

	    public house2(GamePanel oyunPanel) {
	        this.oyunPanel = oyunPanel;
	        name = "house2";

	        try {
	            image = ImageIO.read(getClass().getResourceAsStream("/objects/house2.png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        collision = true;

	        // Adjust this if needed — this is your collision box in the world
	        solidArea.x = 0;
	        solidArea.y = 0;
	        solidArea.width = image.getWidth() * scale;
	        solidArea.height = (image.getHeight() * scale) - 20;
	    }

	    public void draw(Graphics2D g2, GamePanel oyunPanel) {
	        // Calculate where on screen to draw this object
	        int screenX = worldX - oyunPanel.oyuncu.worldX + oyunPanel.oyuncu.screenX;
	        int screenY = worldY - oyunPanel.oyuncu.worldY + oyunPanel.oyuncu.screenY;

	        int objectWidth = image.getWidth() * scale;
	        int objectHeight = image.getHeight() * scale;

	        // Visibility check (draw only if on screen)
	        if (worldX + objectWidth > oyunPanel.oyuncu.worldX - oyunPanel.oyuncu.screenX &&
	            worldX - objectWidth < oyunPanel.oyuncu.worldX + oyunPanel.oyuncu.screenX &&
	            worldY + objectHeight > oyunPanel.oyuncu.worldY - oyunPanel.oyuncu.screenY &&
	            worldY - objectHeight < oyunPanel.oyuncu.worldY + oyunPanel.oyuncu.screenY) {

	            // Draw the image scaled to its proper size
	            g2.drawImage(image, screenX, screenY, objectWidth, objectHeight, null);
	        }
	    }
}
