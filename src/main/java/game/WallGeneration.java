package game;

public class WallGeneration {
    public static void moveEnemy() {
        for (int i = 0; i < Main.wallCount; ++i) {
            Main.xwall[i] += Main.speedwall - Main.speedPlayer;
            //переустановка переменных врага заехавшего далеко за зону видемости
            if (Main.xwall[i] <= -6000 || Main.xwall[i] >= 6000) {
                Main.xwall[i] = (int) ((Math.random() * 5000) + 1000);
                Main.ywall[i] = (int) (50+(Math.random() * 330) );

            }
            //проверка съезда с дороги врагов
            if (Main.ywall[i] < 50) Main.ywall[i] = 50;
            if (Main.ywall[i] > 330) Main.ywall[i] = 330;
        }

    }
}