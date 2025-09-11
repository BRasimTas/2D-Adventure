package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	Clip klip;
	URL soundURL[] = new URL[30];
	
	public Sound() {
		soundURL[0] = getClass().getResource("/sounds/BeepBox-Song.wav");
		soundURL[1] = getClass().getResource("/sounds/item.wav");
		soundURL[2] = getClass().getResource("/sounds/complete.wav");
		soundURL[3] = getClass().getResource("/sounds/unlock.wav");
		soundURL[4] = getClass().getResource("/sounds/dungeon.wav");
		
		
		
	}
	
	
	public void setFile(int i) {
		
		try {
			AudioInputStream sesGiris = AudioSystem.getAudioInputStream(soundURL[i]);
			klip = AudioSystem.getClip();
			klip.open(sesGiris);
			
		} catch (Exception e) {
			
		}
		
	}
	
	public void play( ) {
		
		klip.start();
	}
	
	
	public void loop() {
		klip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	
	public void stop() {
		klip.stop();
	}
	
	
	
	
}
