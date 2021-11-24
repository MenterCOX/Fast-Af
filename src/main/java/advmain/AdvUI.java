package advmain;

import object.AdvBlood;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class will basically handle all the on screen UI
 */
public class AdvUI {

    AdvGamePanel gp;
    Font arial20;
    Font tmn15;
    BufferedImage bloodImage;
    public boolean gameFinished = false;

    public AdvUI(AdvGamePanel gp) {
        this.gp = gp;

        arial20 = new Font("Arial", Font.ITALIC, 20);
        tmn15 = new Font("TimesNewRoman",Font.PLAIN,15);
        AdvBlood blood = new AdvBlood();
        bloodImage = blood.image;
    }

    public void draw(Graphics2D g2) {

        if(gameFinished) {

            g2.setFont(arial20);
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "You have escaped!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); // Just returns length of the text


            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            g2.drawString(text, x, y);
        }
        else {
            g2.setFont(arial20);
            g2.setColor(Color.white);
            g2.drawImage(bloodImage, 0,520, gp.tileSize,gp.tileSize,null);
            g2.drawString("x "+gp.player.hasBlood, 40, 550);

            g2.setFont(tmn15);
            g2.setColor(Color.white);
            g2.drawString("You need 5 blood points to escape this place", 20,40);
        }
    }
}
