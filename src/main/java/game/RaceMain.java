package game;

import javax.swing.*;
import java.util.Random;

/**
 * @author <Cox>
 * @since <pre>нояб. 23, 2021</pre>
 * @version 1.3
 */

public class RaceMain {
    public static Writer writer = new Writer();
    public static JFrame frame = new JFrame("FastAF");
    public static int xBackGround = 0;
    public static int xPlayer = 0;
    public static int yPlayer = 200;
    public static int speedPlayer = 0;
    public static int health = 3;
    public static int score = 0;
    public static int scoreTime = 30;
    public static final int wallCount = 5;
    public static int xwall[] = new int[wallCount];
    public static int ywall[] = new int[wallCount];
    public static int speedwall= 0;
    public static int xCoin = (int) (Math.random() * 10000 + 1000);
    public static int yCoin = (int) (Math.random() * 350 + 50);
    public static boolean dead = false;
    public static boolean go = false;
    public static boolean stop = false;
    public static boolean left = false;
    public static boolean right = false;

    public static final Random r = new Random();

    /**
     * Метод отвечает за начало игры, начальные коородинаты стен
     * Запускаются методы для появления окна и начала цикла
     * @see FrameController#drawFrame()
     * @see GameLoop#loop()
     */
    public static void startGame() {


        for (int i = 0; i < RaceMain.wallCount; ++i) {
            xwall[i] =  ((r.nextInt(7000) + 1000));
            ywall[i] =  ((r.nextInt(400) ));
        }
        FrameController.drawFrame();
        GameLoop.loop();
    }
}