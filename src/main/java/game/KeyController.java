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
                RaceMain.go = true;
                break;
            case KeyEvent.VK_LEFT:
                RaceMain.stop = true;
                break;
            case KeyEvent.VK_UP:
                RaceMain.left = true;
                break;
            case KeyEvent.VK_DOWN:
                RaceMain.right = true;
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
                RaceMain.go = false;
                break;
            case KeyEvent.VK_LEFT:
                RaceMain.stop = false;
                break;
            case KeyEvent.VK_UP:
                RaceMain.left = false;
                break;
            case KeyEvent.VK_DOWN:
                RaceMain.right = false;
                break;
        }
    }
}