package advmain;

import object.AdvBlood;
import object.AdvDoor;

/**
 * Class that consists method to set(install) objects
 */
public class AdvSetter {

    AdvGamePanel gp;

    public AdvSetter(AdvGamePanel gp) {
        this.gp = gp;
    }

    /**
     * Object spawning method
     */
    public void setObject() {

        gp.obj[0] = new AdvBlood();
        gp.obj[0].worldX = 15 * gp.tileSize;
        gp.obj[0].worldY = 9 * gp.tileSize;

        gp.obj[1] = new AdvBlood();
        gp.obj[1].worldX = 28 * gp.tileSize;
        gp.obj[1].worldY = 12 * gp.tileSize;

        gp.obj[2] = new AdvBlood();
        gp.obj[2].worldX = 28 * gp.tileSize;
        gp.obj[2].worldY = 15 * gp.tileSize;

        gp.obj[3] = new AdvBlood();
        gp.obj[3].worldX = 22 * gp.tileSize;
        gp.obj[3].worldY = 17 * gp.tileSize;

        gp.obj[4] = new AdvBlood();
        gp.obj[4].worldX = 12 * gp.tileSize;
        gp.obj[4].worldY = 17 * gp.tileSize;

        gp.obj[5] = new AdvDoor();
        gp.obj[5].worldX = 19 * gp.tileSize;
        gp.obj[5].worldY = 15 * gp.tileSize;
    }
}
