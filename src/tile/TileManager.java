package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	GamePanel gp;
	Tile[] tile;
	int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[10];
		mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];
		getTileImage();
		loadMap("/maps/map_deneme.txt");
		
	}
	
	
	public void getTileImage() {
		
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/Grass1.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/Sand1.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/Water1.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/path.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/flowers_red.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/puddle1.png"));
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/wall_front.png"));
			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/wall_top.png"));
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap(String mapPath) {
		try {
			
			InputStream is = getClass().getResourceAsStream("/maps/map_deneme.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line = br.readLine();
				
				while(col < gp.maxWorldCol ) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
				
				
			}
			br.close();
			
		} catch(Exception e) {
			
		}
		
		
	}
	
	
	public void draw(Graphics2D g2) {
		
		// zoom ile dünyayı çizmek için
		
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			double screenX = worldX - gp.oyuncu.worldX + gp.oyuncu.screenX; 
			double screenY = worldY - gp.oyuncu.worldY + gp.oyuncu.screenY; 
			
			if (worldX  + gp.tileSize > gp.oyuncu.worldX - gp.oyuncu.screenX && 
				worldX  - gp.tileSize < gp.oyuncu.worldX + gp.oyuncu.screenX &&
				worldY  + gp.tileSize > gp.oyuncu.worldY - gp.oyuncu.screenY &&
				worldY  - gp.tileSize < gp.oyuncu.worldY + gp.oyuncu.screenY ) {
				
			g2.drawImage(tile[tileNum].image, (int)screenX,(int)screenY,gp.tileSize,gp.tileSize, null);
			
		
			}
			worldCol++;
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
			
				worldRow++;
		
			}
			
			
			
			
		}
	}
	
}
