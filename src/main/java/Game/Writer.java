package Game;

import Game.Main;

import javax.swing.*;
import java.awt.*;

public class Writer extends JComponent {
    public void paint(Graphics g) {
        //рисование фона
        g.drawImage(new ImageIcon(Writer.class.getResource("/BackGround.png")).getImage(), Main.xBackGround, 0, null);
        g.drawImage(new ImageIcon(Writer.class.getResource("/BackGround.png")).getImage(), Main.xBackGround + 640, 0, null);
        //рисование игрока
        g.drawImage(new ImageIcon(Writer.class.getResource("/Player.png")).getImage(), 100, Main.yPlayer, null);
        //рисование врагв
        for (int i = 0; i < Main.wallCount; ++i) {
            g.drawImage(new ImageIcon(Writer.class.getResource("/Wall.png")).getImage(), Main.xwall[i], Main.ywall[i], null);
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
        g.drawString("скорость: " + Main.speedPlayer + "км/ч", 0, 20);
        g.drawString("расстояние: " + Main.xPlayer / 30 + "м", 0, 40);
        g.drawString("здоровье: " + Main.health, 520, 20);
        g.drawString("очки: " + Main.score, 520, 40);
    }
}