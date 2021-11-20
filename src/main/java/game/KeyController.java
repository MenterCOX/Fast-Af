package game;

import java.awt.event.*;

public class KeyController extends KeyAdapter {
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