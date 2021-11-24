package game;

import javax.swing.*;

import static game.RaceMain.r;

/**
 * Название класса говорит само за себя. Здесь ведётся учет здоровья игрока, движения игрока, слуачя проигрыша
 * вызываются методы для добавления очков,
 */
public class Player {
    /**
     * Метод, который просчитывает здоровье игрока. Если оно равно 0, то вызывается метод,
     * описывающий проигрыш
     * @see Player#dead()
     */
    public static void testdestroy() {

        for (int i = 0; i < RaceMain.wallCount; ++i) {
            if (100 <= RaceMain.xwall[i] +20 &&  300 >= RaceMain.xwall[i] && RaceMain.yPlayer <= RaceMain.ywall[i] + 80 && RaceMain.yPlayer + 80 >= RaceMain.ywall[i] ) {
                for (int j = 0; j < RaceMain.wallCount; ++j) {
                    RaceMain.xwall[j] = ((r.nextInt(50) * 5000) + 5000);
                    RaceMain.ywall[i] = (50+(r.nextInt(200) * 330) );
                }
                --RaceMain.health;
                if (RaceMain.health == 0) dead();
            }
        }
    }

    /**
     * Здесь вызываются методы, в которых игрок получает очки за скорость и монетки
     * @see Bonuse#speedBonus()
     * @see Bonuse#testCatchCoin()
     */
    public static void testAddScore() {

        Bonuse.testCatchCoin();
        Bonuse.speedBonus();
    }

    /**
     * Метод, который возвращает игрока в исходное положение после его проигрыша
     */
    private static void dead() {
        RaceMain.dead = true;
        JOptionPane.showMessageDialog(RaceMain.frame, "You lose!", "FastAF", JOptionPane.WARNING_MESSAGE);
        RaceMain.xBackGround = 0;
        RaceMain.xPlayer = 0;
        RaceMain.yPlayer = 200;
        RaceMain.speedPlayer = 0;
        RaceMain.health = 3;
        RaceMain.score = 0;
        RaceMain.dead = false;
        RaceMain.go = false;
        RaceMain.stop = false;
        RaceMain.left = false;
        RaceMain.right = false;
        GameLoop.loop();
    }

    /**
     * Метод, отвечающий за движение игрока
     */
    public static void movePlayer() {
        RaceMain.xBackGround -= RaceMain.speedPlayer;
        RaceMain.xPlayer += RaceMain.speedPlayer;
        if (RaceMain.go) ++RaceMain.speedPlayer;
        if (RaceMain.stop) --RaceMain.speedPlayer;
        if (RaceMain.left) RaceMain.yPlayer -=  15;
        if (RaceMain.right) RaceMain.yPlayer +=  15 ;
        if (RaceMain.speedPlayer < 0) RaceMain.speedPlayer = 0;
        if (RaceMain.speedPlayer > 51) RaceMain.speedPlayer = 51;
        if (RaceMain.yPlayer < 50) RaceMain.yPlayer = 50;
        if (RaceMain.yPlayer > 350) RaceMain.yPlayer = 350;
    }
}