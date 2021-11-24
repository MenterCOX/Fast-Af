package advmain;

import game.RaceMain;

import javax.swing.*;

public class Application {

        public static void main(String[] args) {


                GUI app = new GUI();
                app.setLocationRelativeTo(null);
                app.setVisible(true);

                RaceMain race = new RaceMain();
                race.startGame();
                System.out.println(app.dolboeb);
        }
}
