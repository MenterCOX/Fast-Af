package advmain;

import advEntity.AdvPlayer;
import tile.AdvTileManager;

import javax.swing.*;
import java.awt.*;

/**
 * SubClass of the JPanel. Game screen function. It will
 * draw it inside jframe window. implements runnable for using Thread
 */
public class AdvGamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    //World Settings
    public final int maxWorldCol = 30;
    public final int maxWorldRow = 15;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    // FPS
    double FPS = 60d;

    AdvTileManager tileM = new AdvTileManager(this);
    AdvKeyHandler keyH = new AdvKeyHandler();
    Thread gameThread;
    public AdvCollisionChecker cChecker = new AdvCollisionChecker(this);
    public AdvPlayer player = new AdvPlayer(this, keyH);


    /**
     * Constructor for Game Panel Class.
     */
    public AdvGamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    /**
     * Method that starts main thread of the game and adds it to the main constructor
     */
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Method that is automatically called by Thread method.
     */
    @Override
    public void run() { // Game loop 60 fps

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        //Main While loop. Exists while gameThread is active
        while(gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;
            if (delta >= 1) {
                // 1 UPDATE: update information
                update();

                // 2 DRAW: draw the screen with the updated information
                repaint();
                delta--;
            }
        }
    }

    /**
     * This update method calls methos from player class, that updates the player coordinates
     */
    public void update() {

        player.update();
    }
    public void paintComponent(Graphics g){

        //This panel is a subclass of JPanel
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);

        player.draw(g2);

        g2.dispose();
    }
}

