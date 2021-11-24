package game;

import javax.swing.*;
import java.awt.*;

/**
 *Этот класс отвечает за прорисовку заднего фона, модельки игрока(машины), препятствий, а такеж рисование монеты и
 * всей информации об игроке(пройденное расстояние, очки, здоровье)
 */
public class Writer extends JComponent {

    /**
     * @param g - вывод всей графики.
     *          Здесь производится прорисовка всего вышеописанного
     */
    public void paint(Graphics g) {
        g.drawImage(new ImageIcon(Writer.class.getResource("/Images/BackGround.png")).getImage(), RaceMain.xBackGround, 0, null);
        g.drawImage(new ImageIcon(Writer.class.getResource("/Images/BackGround.png")).getImage(), RaceMain.xBackGround + 640, 0, null);
        g.drawImage(new ImageIcon(Writer.class.getResource("/Images/Player.png")).getImage(), 100, RaceMain.yPlayer, null);
        for (int i = 0; i < RaceMain.wallCount; ++i) {
            g.drawImage(new ImageIcon(Writer.class.getResource("/Images/Wall.png")).getImage(), RaceMain.xwall[i], RaceMain.ywall[i], null);
        }
        g.setColor(Color.YELLOW);
        g.fillOval(RaceMain.xCoin, RaceMain.yCoin, 50, 50);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("$", RaceMain.xCoin + 10, RaceMain.yCoin + 42);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Speed: " + RaceMain.speedPlayer + "km/h", 0, 20);
        g.drawString("Distance: " + RaceMain.xPlayer / 30 + "m", 0, 40);
        g.drawString("HP: " + RaceMain.health, 520, 20);
        g.drawString("Points: " + RaceMain.score, 520, 40);
    }
}