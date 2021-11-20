package Game;

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
            Main.xCoin = (int) (Math.random() * 10000 + 1000);
            Main.yCoin = (int) (Math.random() * 350 + 50);
        }
        Main.writer.repaint();

        try {
            Thread.sleep(1000 / 30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!Main.dead) loop();
    }
}