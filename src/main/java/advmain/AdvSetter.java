package advmain;

import object.AdvBlood;
import object.AdvDoor;
import object.AdvExit;

/**
 * Class that consists method to set(install) objects
 */
public class AdvSetter {

    AdvGamePanel gp;

    /**
     * @param gp
     * Constructor for public class AdvSetter
     */
    public AdvSetter(AdvGamePanel gp) {
        this.gp = gp;
    }

    /**
     * Object spawning method
     */
    public void setObject() {

        gp.obj[0] = new AdvBlood();
        gp.obj[0].worldX = 15 * gp.tileSize;
        gp.obj[0].worldY = 10 * gp.tileSize;

        gp.obj[1] = new AdvBlood();
        gp.obj[1].worldX = 28 * gp.tileSize;
        gp.obj[1].worldY = 12 * gp.tileSize;

        gp.obj[2] = new AdvBlood();
        gp.obj[2].worldX = 37 * gp.tileSize;
        gp.obj[2].worldY = 14 * gp.tileSize;

        gp.obj[3] = new AdvBlood();
        gp.obj[3].worldX = 25 * gp.tileSize;
        gp.obj[3].worldY = 18 * gp.tileSize;

        gp.obj[4] = new AdvBlood();
        gp.obj[4].worldX = 12 * gp.tileSize;
        gp.obj[4].worldY = 18 * gp.tileSize;

        gp.obj[5] = new AdvDoor();
        gp.obj[5].worldX = 19 * gp.tileSize;
        gp.obj[5].worldY = 10 * gp.tileSize;

        gp.obj[6] = new AdvExit();
        gp.obj[6].worldX = 19 * gp.tileSize;
        gp.obj[6].worldY = 16 * gp.tileSize;
    }
}
