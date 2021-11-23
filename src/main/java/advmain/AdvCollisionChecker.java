package advmain;

import advEntity.AdvEntity;

import javax.swing.text.html.parser.Entity;

public class AdvCollisionChecker {

    AdvGamePanel gp;

    public AdvCollisionChecker(AdvGamePanel gp) {
        this.gp = gp;
    }

    /**
     * @param entity Method that checks presence of the collision in two near tiles in player direction
     */
    public void checkTile(AdvEntity entity) {

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol] [entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol] [entityTopRow];
                if (gp.tileM.advtile[tileNum1].collision == true || gp.tileM.advtile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol] [entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol] [entityBottomRow];
                if (gp.tileM.advtile[tileNum1].collision == true || gp.tileM.advtile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol] [entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol] [entityBottomRow];
                if (gp.tileM.advtile[tileNum1].collision == true || gp.tileM.advtile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol] [entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol] [entityBottomRow];
                if (gp.tileM.advtile[tileNum1].collision == true || gp.tileM.advtile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
        }
    }

    /**
     * @param entity
     * @param player
     * Method that checking all objects at the map and their collision
     * @return index of the object that player disturbs
     */
    public int checkObject(AdvEntity entity, boolean player) {

        int index = 228;

        // Scanning object array
        for (int i = 0; i < gp.obj.length; i++) {

            if(gp.obj[i] != null) {
                // Get entity's solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                // Get the object's solid area position
                gp.obj[i].solidArea.x = gp.obj[i].worldX  + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                // Simulating entity's movement and checking position after
                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) { // intersects method checks if these rectangles touches each other
                            if(gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) { // intersects method checks if these rectangles touches each other
                            if(gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) { // intersects method checks if these rectangles touches each other
                            if(gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) { // intersects method checks if these rectangles touches each other
                            if(gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }

        return index;
    }
}
