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
        RaceMain.frame.setSize(660, 500);
        RaceMain.frame.setResizable(false);
        RaceMain.frame.setLocationRelativeTo(null);
        RaceMain.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        RaceMain.frame.setIconImage(new ImageIcon(FrameController.class.getResource("/Images/Icon.png")).getImage());
        RaceMain.frame.add(RaceMain.writer);
        RaceMain.frame.addKeyListener(new KeyController());
        RaceMain.frame.setVisible(true);
    }
}