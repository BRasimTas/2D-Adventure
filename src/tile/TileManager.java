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
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[50];
		mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];
		getTileImage();
		loadMap("/maps/level_map1.txt");
		
	}
	
	
	public void getTileImage() {
		
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/Water1.png"));
			tile[0].collision = true;
					
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/Grass1.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/bottom_right_grass.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/Tree_on_grass.png"));
			tile[3].collision = true;
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/path_top_grass.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/path_bottom_grass.png"));
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/wall_front.png"));
			tile[6].collision = true;
			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/path_tl_grass.png"));
			
			
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/path_left_grass.png"));

			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/path_right_grass.png"));
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/path_tlc_grass.png"));
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/path_brc_grass.png"));
			
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/path_reverse_L.png"));
			
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/path_right_L.png"));
			
			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/path_right_top_corner.png"));
			
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/path_right_left_corner.png"));
			
			tile[16] = new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/Sand1.png"));
			
			tile[17] = new Tile();
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/reeds1.png"));
			
			tile[18] = new Tile();
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/bridge_way.png"));
			
			tile[19] = new Tile();
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/bridge_wall1.png"));
			tile[19].collision = true;
			
			tile[20] = new Tile();
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/boat1.png"));
			tile[20].collision = true;
			
			tile[21] = new Tile();
			tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/boat2.png"));
			tile[21].collision = true;
			
			tile[22] = new Tile();
			tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/boat3.png"));
			tile[22].collision = true;
			
			tile[23] = new Tile();
			tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/boat4.png"));
			tile[23].collision = true;
			
			tile[24] = new Tile();
			tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/boat5.png"));
			tile[24].collision = true;
			
			tile[25] = new Tile();
			tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/boat6.png"));
		//	tile[25].collision = true;
		
			tile[26] = new Tile();
			tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/well1.png"));
			tile[26].collision = true;
			
			tile[27] = new Tile();
			tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/well2.png"));
			tile[27].collision = true;
			
			tile[28] = new Tile();
			tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/well3.png"));
			tile[28].collision = true;
			
			tile[29] = new Tile();
			tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tile_pack1/well4.png"));
			tile[29].collision = true;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap(String mapPath) {
		try {
			
			InputStream is = getClass().getResourceAsStream("/maps/level_map1.txt");
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
		
		
		
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.oyuncu.worldX + gp.oyuncu.screenX; 
			int screenY = worldY - gp.oyuncu.worldY + gp.oyuncu.screenY; 
			
			if (worldX  + gp.tileSize > gp.oyuncu.worldX - gp.oyuncu.screenX && 
				worldX  - gp.tileSize < gp.oyuncu.worldX + gp.oyuncu.screenX &&
				worldY  + gp.tileSize > gp.oyuncu.worldY - gp.oyuncu.screenY &&
				worldY  - gp.tileSize < gp.oyuncu.worldY + gp.oyuncu.screenY ) {
				
			g2.drawImage(tile[tileNum].image, screenX,screenY,gp.tileSize,gp.tileSize, null);
			
		
			}
			worldCol++;
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
			
				worldRow++;
		
			}
			
			
			
			
		}
	}
	
}
