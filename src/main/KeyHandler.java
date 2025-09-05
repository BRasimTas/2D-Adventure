package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	public boolean upPress, downPress, leftPress, rightPress;
	public int zoomLevel = 0;
	GamePanel oyunPanel;
	
	public KeyHandler(GamePanel oyunPanel) {
		this.oyunPanel = oyunPanel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPress = true;
		}
		if(code == KeyEvent.VK_A) {
			leftPress = true;
		}
		if(code == KeyEvent.VK_S) {
			downPress = true;
		}
		if(code == KeyEvent.VK_D) {
			rightPress = true;
		}
		
	//  sadece map_zoom dalında var
		if(code == KeyEvent.VK_ALT) {
			System.out.println("zoom button pressed");
			
			
			if (zoomLevel > 2) {zoomLevel = -2;}
			int zoomIndex = zoomLevel * 16;
			oyunPanel.zoomInOut(zoomIndex);
			System.out.println(zoomLevel);
			zoomLevel++;
			
			
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPress = false;
		}
		if(code == KeyEvent.VK_A) {
			leftPress = false;
		}
		if(code == KeyEvent.VK_S) {
			downPress = false;
		}
		if(code == KeyEvent.VK_D) {
			rightPress = false;
		}
		
	}

}
