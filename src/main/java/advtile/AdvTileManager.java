package advtile;

import advmain.AdvGamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AdvTileManager {

    AdvGamePanel gp;
    public AdvTile[] advtile;
    public int mapTileNum[] [];

    public AdvTileManager(AdvGamePanel gp) {

        this.gp = gp;

        advtile = new AdvTile[10];
        mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/world01.txt");
    }

    public void getTileImage() {

        try {
            advtile[0] = new AdvTile();
            advtile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            advtile[1] = new AdvTile();
            advtile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            advtile[1].collision = true;

            advtile[2] = new AdvTile();
            advtile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            advtile[2].collision = true;

            advtile[3] = new AdvTile();
            advtile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));

            advtile[4] = new AdvTile();
            advtile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            advtile[4].collision = true;

            advtile[5] = new AdvTile();
            advtile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath) {

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow) {

                String line = br.readLine();

                while(col < gp.maxWorldCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col] [row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
        catch (Exception e) {

        }
    }
    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol] [worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            g2.drawImage(advtile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
