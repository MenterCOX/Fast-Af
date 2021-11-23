package game;

import javax.swing.*;

/**
 * Класс отвечает за само окно вывода и все с ним связанное
 */
public class FrameController {
    /**
     * Метод создает окно и делает его видимым
     */
    public static void drawFrame() {
        Main.frame.setSize(660, 500);
        Main.frame.setResizable(false);
        Main.frame.setLocationRelativeTo(null);
        Main.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Main.frame.setIconImage(new ImageIcon(FrameController.class.getResource("/Images/Icon.png")).getImage());
        Main.frame.add(Main.writer);
        Main.frame.addKeyListener(new KeyController());
        Main.frame.setVisible(true);
    }
}