package ui;

import model.Snake;
import model.SnakePiece;

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
    private final static int WIDTH = 500;
    private final static int HEIGHT = 400;
    public Window() {
        super("Snake");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Snake snake = new Snake(WIDTH / 2, HEIGHT / 2);

        MyCanvas canvas = new MyCanvas(snake);
        canvas.setBackground(Color.BLACK);
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        super.getContentPane().add(canvas);
        super.pack();
        super.setVisible(true);
    }
}
