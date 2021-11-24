package game;

/**
 * Класс отвечает за очки, которые начисляются игроку за пройденное расстояние и монеты,
 * а также за местоположение монеты
 */
public class Bonuse {

    /**
     * Метод отвечает за  монету: ее местоположение и начисление очков за неё
     */
    public static void testCatchCoin() {
        if (100 <= RaceMain.xCoin + 50 && 300 >= RaceMain.xCoin && RaceMain.yPlayer <= RaceMain.yCoin + 50 && RaceMain.yPlayer + 80 >= RaceMain.yCoin) {
            RaceMain.xCoin = (int) (Math.random() * 10000 + 1000);
            RaceMain.yCoin = (int) (Math.random() * 350 + 50);
            RaceMain.score += 5;
        }
    }

    /**
     * Этот метод отвечает за бонус, который начисляется игроку за скорость
     */
    public static void speedBonus() {
        if (RaceMain.scoreTime < 0) {
            RaceMain.scoreTime = 30;
            RaceMain.score += (RaceMain.speedPlayer) / 15;
        }
    }
}