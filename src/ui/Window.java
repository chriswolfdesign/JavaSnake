package ui;

import model.Snake;

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
    private Snake snake;
    private MyCanvas canvas;

    public Window(Snake snake, int width, int height) {
        super("Snake");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new MyCanvas(snake);
        canvas.setBackground(Color.BLACK);
        canvas.setPreferredSize(new Dimension(width , height));
        canvas.addKeyListener(new ArrowKeyListener(snake));

        super.getContentPane().add(canvas);
        super.pack();
        super.setVisible(true);
        this.requestFocus();
    }

    public void update() {
        canvas.repaint();
    }
}
