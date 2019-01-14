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
    private int width;
    private int height;

    public Window(Snake snake, int width, int height) {
        super("Snake");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.width = width;
        this.height = height;
        this.snake = snake;

        // Do not allow apple to spawn on top of the snake
        do {
            this.apple = new Apple(width, height);
        } while(snake.isTouchingApple(apple));

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
     * Getter for our snake
     *
     * @return {Snake} -- the snake it our game
     */
    public Snake getSnake() {
        return this.snake;
    }

    /**
     * Setter for our snake
     *
     * @param {Snake} snake -- the new snake for our game
     */
    public void setSnake(Snake snake) {
        this.snake = snake;
        this.canvas.setSnake(snake);
    }

    /**
     * Forces the canvas to repaint the snake and apple onto the screen.
     */
    public void update() {
        if(snake.isTouchingApple(apple)) {
            snake.addPiece();

            // Again, do not allow apple to spawn on top of the snake
            do {
                this.setApple(new Apple(width, height));
            } while(snake.isTouchingApple(apple));
        }

        canvas.repaint();
    }
}
