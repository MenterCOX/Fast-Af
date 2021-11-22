package advmain;

import object.AdvBlood;

public class AdvSetter {

    AdvGamePanel gp;

    public AdvSetter(AdvGamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj[0] = new AdvBlood();
        gp.obj[0].worldX = 10 * gp.tileSize;
        gp.obj[0].worldY = 1 * gp.tileSize;

    }
}
