package advmain;

import javax.swing.JFrame;
public class AdvMain {
     public AdvMain() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        AdvGamePanel gamePanel = new AdvGamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null); // Window will be displayed at the center of the screen
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
