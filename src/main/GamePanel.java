package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	// SCREEN SETTINGS
	final int originalTileSize = 16;  //16x16 kare boyutu
    final int scale = 3;  // kareleri büyütmek için

	public  int tileSize = originalTileSize * scale; // 48x48 kareler
	public  int maxScreenCol = 16;
	public  int maxScreenRow = 12;
	public  int screenWidth = tileSize * maxScreenCol; // 768 pixel
	public  int screenHeight = tileSize * maxScreenRow; // 576 pixel 
	
	//dünya ayarları, dünyayı kaydırmak için.
	public final int maxWorldCol = 42;
	public final int maxWorldRow = 32;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	
	
	
	// FPS  gösterme
	int FPS = 60;
	
	
	TileManager karoM = new TileManager(this);
	KeyHandler tuslar = new KeyHandler(this);
	Thread oyunThread;
	public Player oyuncu = new Player(this,tuslar);
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(tuslar);
		this.setFocusable(true);
	}
	//
	// sadece map_zomm versiyonda var
	//
	public void zoomInOut(int a) {
		
		int oldWorldWidth = tileSize * maxWorldCol;
		
		tileSize = originalTileSize * scale;
		tileSize = tileSize + a;
		if (tileSize > 72 ) {
			tileSize = originalTileSize * scale;
		}
		System.out.println(tileSize);
		
		int newWorldWidth = tileSize * maxWorldCol;
		
		double oran = (double)newWorldWidth / oldWorldWidth;
		
		double newOyuncuWorldX = oyuncu.worldX * oran;
		double newOyuncuWorldY = oyuncu.worldY * oran;
		
		oyuncu.worldX = newOyuncuWorldX;
		oyuncu.worldY = newOyuncuWorldY;
		
		oyuncu.speed = (double)newWorldWidth/500;
	}
	
	public void oyunThreadBaslat() {
		
		oyunThread = new Thread(this);
		oyunThread.start();
	}
	
/*	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;		
		
		while (oyunThread != null) {   
			// oyunda sürekli tekrar eden şeyler burada olacak. mesela karakter çizme
			
		//	long currentTime = System.nanoTime();
		//	System.out.println("Currnent time: " + currentTime);
			
			// Ekrandaki bilgileri güncelliyoruz
			update();
			
			//sonra bu bilgileri çiziyoruz. oyun 30 fps ise saniyede 30 kez yapıyoruz 
			repaint();
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
			    remainingTime = remainingTime / 1000000;
			    
			    if (remainingTime < 0) {
			    	remainingTime = 0;
			    }
			    
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
*/
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(oyunThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if (delta >= 1 ) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			
			if (timer >= 1000000000) {
				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
		
		update();
		repaint();
		
	}
	
	
	public void update() {
		
		oyuncu.update();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		karoM.draw(g2);
		
		oyuncu.draw(g2);
		
		g2.dispose();
		
	}
}
