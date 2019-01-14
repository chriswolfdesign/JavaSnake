package ui;

import model.Snake;
import model.Apple;

import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 * Game.java
 *
 * The entry point for our Snake game.
 *
 * @author Chris Wolf
 * @version 1.0.0 (January 9, 2019)
 *
 * chriswolfdesign@gmail.com
 */
public class Game {
    public static void main(String[] args) {
        final int WIDTH = 500;
        final int HEIGHT = 400;
        Snake snake = new Snake(WIDTH, HEIGHT);
        Apple apple = new Apple(WIDTH, HEIGHT);
        Window window = new Window(snake, apple, WIDTH, HEIGHT);

        while(true) {
            // wait 0.1 seconds to make game playable
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException ie) {
                System.out.println("Timer interrupted.");
            }
            snake.move();
            window.update();

            if(snake.outOfBounds()) {
                JOptionPane.showMessageDialog(window, "You went out of bounds :_(");
                System.exit(0);
            }
        }
    }
}
