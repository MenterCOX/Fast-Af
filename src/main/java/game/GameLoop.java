package game;

import static game.RaceMain.r;

/**
 * Класс отвечает за игровой цикл и все что происходит в нем
 */
public class GameLoop {
    /**
     * Метод, в котором зацикливается движения игрока, появление новых препятствий, повление новых монет
     * @see Player#testdestroy()
     * @see Player#testAddScore()
     * @see Player#movePlayer()
     * @see WallGeneration#wallgen()
     */
    public static void loop() {
        Player.testdestroy();
        Player.testAddScore();
        Player.movePlayer();
        WallGeneration.wallgen();

        if (RaceMain.xBackGround <= -640) RaceMain.xBackGround = 0;
        RaceMain.xCoin -= RaceMain.speedPlayer;
        --RaceMain.scoreTime;
        if (RaceMain.xCoin < 0) {
            RaceMain.xCoin =(r.nextInt(50) * 10000 + 1000);
            RaceMain.yCoin = (r.nextInt(200) * 350 + 50);
        }
        RaceMain.writer.repaint();

        try {
            Thread.sleep(1000 / 30);
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        if (!RaceMain.dead) loop();
    }
    }