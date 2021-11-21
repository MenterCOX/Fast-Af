package game;

import java.util.Random;

import static game.Main.r;

public class GameLoop {

    public static void loop() {
        Player.testdestroy();
        Player.testAddScore();
        Player.movePlayer();
        WallGeneration.moveEnemy();

        if (Main.xBackGround <= -640) Main.xBackGround = 0;
        Main.xCoin -= Main.speedPlayer;
        --Main.scoreTime;
        if (Main.xCoin < 0) {
            Main.xCoin =(r.nextInt(50) * 10000 + 1000);
            Main.yCoin = (r.nextInt(200) * 350 + 50);
        }
        Main.writer.repaint();

        try {
            Thread.sleep(1000 / 30);
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        if (!Main.dead) loop();
    }
}