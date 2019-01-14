package ui;

import model.Snake;
import model.Apple;

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
    private Apple apple;
    private MyCanvas canvas;

    public Window(Snake snake, Apple apple, int width, int height) {
        super("Snake");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.snake = snake;
        this.apple = apple;

        canvas = new MyCanvas(snake, apple);
        canvas.setBackground(Color.BLACK);
        canvas.setPreferredSize(new Dimension(width , height));
        canvas.addKeyListener(new ArrowKeyListener(snake));

        super.getContentPane().add(canvas);
        super.pack();
        super.setVisible(true);
        this.requestFocus();
    }

    /**
     * Getter for our apple
     *
     * @return {Apple} -- the apple in our game
     */
    public Apple getApple() {
        return canvas.getApple();
    }

    /**
     * Setter for out apple
     *
     * @param {Apple} apple -- the new apple for our game
     */
    public void setApple(Apple apple) {
        this.apple = apple;
        this.canvas.setApple(apple);
    }

    /**
     * Forces the canvas to repaint the snake and apple onto the screen.
     */
    public void update() {
        canvas.repaint();
    }
}
