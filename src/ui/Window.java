package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Window.java
 *
 * The class that will create and maintain the window in which the game is run.
 *
 * @author Chris Wolf
 * @version 1.0.0 (January 9, 2019)
 *
 * chriswolfdesign@gmail.com
 */

public class Window extends JFrame {
    public Window() {
        super("Snake");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(500, 400));
        super.getContentPane().add(panel);
        super.pack();
        super.setVisible(true);
    }
}
