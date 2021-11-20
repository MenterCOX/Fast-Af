package Game;

public class Bonuses {


    public static void testCatchCoin() {
        if (100 <= Main.xCoin + 50 && 300 >= Main.xCoin && Main.yPlayer <= Main.yCoin + 50 && Main.yPlayer + 80 >= Main.yCoin) {
            Main.xCoin = (int) (Math.random() * 10000 + 1000);
            Main.yCoin = (int) (Math.random() * 350 + 50);
            Main.score += 5;
        }
    }

    public static void speedBonus() {
        if (Main.scoreTime < 0) {
            Main.scoreTime = 30;
            Main.score += (Main.speedPlayer) / 15;
        }
    }
}