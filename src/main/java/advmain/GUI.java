package advmain;

import game.RaceMain;
import sngame.GameFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{

    private JLabel label = new JLabel("Choose game");
    AdvGamePanel gp = new AdvGamePanel();
    AdvMain adv = new AdvMain();
    RaceMain race = new RaceMain();
    GameFrame sn = new GameFrame();

    public GUI( ) {
        this.setTitle("Fast-Af");
        this.setSize(800, 600);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        getContentPane().add(panel);

        JLabel label = new JLabel("Choose game !");
        this.add(label);
        label.setBounds(335,20,150,80);

        JButton button1 = new JButton("Adventure");
        button1.setBounds(230, 100, 300, 40);
        button1.addActionListener(new Button1EventListener ());
        this.add(button1);

        JButton button2 = new JButton("Race");
        button2.setBounds(230, 200, 300, 40);
        button2.addActionListener(new Button2EventListener ());
        this.add(button2);

        JButton button3 = new JButton("Snake");
        button3.setBounds(230, 300, 300, 40);
        button3.addActionListener(new Button3EventListener ());
        this.add(button3);

        this.setLayout(null);

    }

    class Button1EventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            adv.main();
        }
    }
    class Button2EventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            race.main(null);
        }
    }
    class Button3EventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            sn.main();
        }
    }
}
