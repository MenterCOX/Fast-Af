package game;

/**
 * Класс, отвечающий за генерацию местоположения препятствий
 */
public class WallGeneration {
    /**
     * Метод, отвечающий за генерацию местоположения препятствий
     */
    public static void wallgen() {
        for (int i = 0; i < RaceMain.wallCount; ++i) {
            RaceMain.xwall[i] += RaceMain.speedwall - RaceMain.speedPlayer;
            if (RaceMain.xwall[i] <= -6000 || RaceMain.xwall[i] >= 6000) {
                RaceMain.xwall[i] = (int) ((Math.random() * 5000) + 1000);
                RaceMain.ywall[i] = (int) (50+(Math.random() * 330) );

            }
            if (RaceMain.ywall[i] < 50) RaceMain.ywall[i] = 50;
            if (RaceMain.ywall[i] > 330) RaceMain.ywall[i] = 330;
        }

    }
}