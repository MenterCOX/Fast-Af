package game;

import javax.swing.*;
import java.util.Random;

public class Player {
    public static void testdestroy() {
        Random r = new Random();
        for (int i = 0; i < Main.wallCount; ++i) {
            if (100 <= Main.xwall[i] +20 &&  300 >= Main.xwall[i] && Main.yPlayer <= Main.ywall[i] + 80 && Main.yPlayer + 80 >= Main.ywall[i] ) {
                for (int j = 0; j < Main.wallCount; ++j) {
                    Main.xwall[j] = ((r.nextInt(50) * 5000) + 5000);
                    Main.ywall[i] = (50+(r.nextInt(200) * 330) );
                }
                --Main.health;
                if (Main.health == 0) dead();
            }
        }
    }

    public static void testAddScore() {

        Bonuse.testCatchCoin();
        Bonuse.speedBonus();
    }

    private static void dead() {
        Main.dead = true;
        JOptionPane.showMessageDialog(Main.frame, "You lose!", "FastAF", JOptionPane.WARNING_MESSAGE);
        Main.xBackGround = 0;
        Main.xPlayer = 0;
        Main.yPlayer = 200;
        Main.speedPlayer = 0;
        Main.health = 3;
        Main.score = 0;
        Main.dead = false;
        Main.go = false;
        Main.stop = false;
        Main.left = false;
        Main.right = false;
        GameLoop.loop();
    }

    public static void movePlayer() {
        Main.xBackGround -= Main.speedPlayer;
        Main.xPlayer += Main.speedPlayer;
        if (Main.go) ++Main.speedPlayer;
        if (Main.stop) --Main.speedPlayer;
        if (Main.left) Main.yPlayer -=  15;
        if (Main.right) Main.yPlayer +=  15 ;
        if (Main.speedPlayer < 0) Main.speedPlayer = 0;
        if (Main.speedPlayer > 51) Main.speedPlayer = 51;
        if (Main.yPlayer < 50) Main.yPlayer = 50;
        if (Main.yPlayer > 350) Main.yPlayer = 350;
    }
}