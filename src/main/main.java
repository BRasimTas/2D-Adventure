package main;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Sexy Oyun");
		
		GamePanel oyunPanel = new GamePanel();
		window.add(oyunPanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		oyunPanel.oyunThreadBaslat();
	}

}
