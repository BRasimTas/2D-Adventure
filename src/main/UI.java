package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class UI {
	
	private BufferedImage image;
	private GamePanel oyunPanel;
	private Font Goudy, arial_80B;
	public boolean gameFinished = false;
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	
	private class Message {
		String text;
		int counter;

		Message(String text) {
			this.text = text;
			this.counter = 0;
		}
	}

	private ArrayList<Message> messages = new ArrayList<>();

	public UI(GamePanel oyunPanel) {
		this.oyunPanel = oyunPanel;
		Goudy = new Font("Arial", Font.BOLD, 40);
		arial_80B = new Font("Arial", Font.BOLD, 60);
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Gold_key1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showMessage(String text) {
		messages.add(new Message(text));
	}

	public void draw(Graphics2D g2) {
		
		if (gameFinished == true) {
			String text, text1;
			int textLength, textLength1;
		
			
			text = "level Complete!";
			textLength = (int)oyunPanel.getFontMetrics(Goudy).getStringBounds(text, g2).getWidth();
			
			g2.setFont(Goudy);
			g2.setColor(Color.PINK);	
			
			
			int x = oyunPanel.screenWidth/2 - textLength/2;
			int y = oyunPanel.screenHeight/2;
			
			g2.drawString(text, x, y);
		//
			//
			//
			//
			//
			
			g2.setColor(Color.YELLOW);
			g2.setFont(arial_80B);
			text1 = "Congrats!";
			textLength = (int)oyunPanel.getFontMetrics(arial_80B).getStringBounds(text1, g2).getWidth();
			int x1 = oyunPanel.screenWidth/2 - textLength/2;
			int y1 = oyunPanel.screenHeight/2 - 55;
			g2.drawString(text1, x1, y1);
			
			oyunPanel.oyunThread = null;
		} else {
			
			playTime += (double)1/60;
			g2.setColor(Color.WHITE);
			g2.setFont(g2.getFont().deriveFont(15F));
			
			
			
			g2.drawString("Time:" + dFormat.format(playTime), 680 ,70);
			
			
		}
		
		
		
		
		
		// Draw key image and count
		g2.setFont(Goudy);
		g2.setColor(Color.WHITE);	
		g2.drawString("= " + oyunPanel.oyuncu.hasGoldKey, 700 , 45);
		g2.drawImage(image, 660, 10, 48, 48, null);

		// Draw messages
		g2.setFont(g2.getFont().deriveFont(15F));

		for (int i = 0; i < messages.size(); i++) {
			Message msg = messages.get(i);
			g2.drawString(msg.text, 15, 500 + (i * 20));
			msg.counter++;

			// Remove message after 120 frames (~2 seconds at 60 FPS)
			if (msg.counter > 120) {
				messages.remove(i);
				i--; // Adjust index after removal
			}
		}
	}
}
