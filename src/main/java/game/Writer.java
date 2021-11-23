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
        //рисование фона
        g.drawImage(new ImageIcon(Writer.class.getResource("/Images/BackGround.png")).getImage(), Main.xBackGround, 0, null);
        g.drawImage(new ImageIcon(Writer.class.getResource("/Images/BackGround.png")).getImage(), Main.xBackGround + 640, 0, null);
        //рисование игрока
        g.drawImage(new ImageIcon(Writer.class.getResource("/Images/Player.png")).getImage(), 100, Main.yPlayer, null);
        //рисование препятствий
        for (int i = 0; i < Main.wallCount; ++i) {
            g.drawImage(new ImageIcon(Writer.class.getResource("/Images/Wall.png")).getImage(), Main.xwall[i], Main.ywall[i], null);
        }
        //рисование монеты
        g.setColor(Color.YELLOW);
        g.fillOval(Main.xCoin, Main.yCoin, 50, 50);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("$", Main.xCoin + 10, Main.yCoin + 42);
        //рисование текста на верху экрана
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Speed: " + Main.speedPlayer + "km/h", 0, 20);
        g.drawString("Distance: " + Main.xPlayer / 30 + "m", 0, 40);
        g.drawString("HP: " + Main.health, 520, 20);
        g.drawString("Points: " + Main.score, 520, 40);
    }
}