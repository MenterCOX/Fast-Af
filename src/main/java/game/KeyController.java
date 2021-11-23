package game;

import java.awt.event.*;

/**
 * Этот класс отвечает за данные, введенные с клавиатуры, а именно за движение игрока
 */
public class KeyController extends KeyAdapter {
    /**
     * @param e действия, вводимые с клавиатуры.
     * Этот метод отвчечает за действия, которые производятся при нажатых клавишах
     */
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                Main.go = true;
                break;
            case KeyEvent.VK_LEFT:
                Main.stop = true;
                break;
            case KeyEvent.VK_UP:
                Main.left = true;
                break;
            case KeyEvent.VK_DOWN:
                Main.right = true;
                break;
        }
    }
    /**
     * @param e действия, вводимые с клавиатуры.
     * Этот метод отвчечает за действия, которые производятся после нажатия клавиш
     */
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                Main.go = false;
                break;
            case KeyEvent.VK_LEFT:
                Main.stop = false;
                break;
            case KeyEvent.VK_UP:
                Main.left = false;
                break;
            case KeyEvent.VK_DOWN:
                Main.right = false;
                break;
        }
    }
}