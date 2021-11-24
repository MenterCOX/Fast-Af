package advmain;

import advEntity.AdvPlayer;
import object.AdvSuperObject;
import advtile.AdvTileManager;

import javax.swing.*;
import java.awt.*;

/**
 * SubClass of the JPanel. Game screen function. It will
 * draw it inside jframe window. Implements runnable for using Thread
 */
public class AdvGamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 advtile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48x48 advtile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    //World Settings
    public final int maxWorldCol = 48;
    public final int maxWorldRow = 25;

    // FPS
    double FPS = 60d;

    // System
    AdvTileManager tileM = new AdvTileManager(this);
    AdvKeyHandler keyH = new AdvKeyHandler();
    public AdvCollisionChecker cChecker = new AdvCollisionChecker(this);
    public AdvSetter aSetter = new AdvSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;

    //Entity and object
    public AdvPlayer player = new AdvPlayer(this, keyH);
    public AdvSuperObject obj[] = new AdvSuperObject[10];



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

    public void setupGame() {

        aSetter.setObject();
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

    /**
     * @param g
     *
     */
    public void paintComponent(Graphics g){
        //This panel is a subclass of JPanel
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        // Tile
        tileM.draw(g2);

        // Object
        for(int i = 0; i < obj.length; i++) {
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }

        // Player
        player.draw(g2);

        // UI
        ui.draw(g2);

        g2.dispose();
    }
}

