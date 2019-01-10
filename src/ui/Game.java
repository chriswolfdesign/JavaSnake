package ui;

import model.Snake;

import java.util.concurrent.TimeUnit;

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
        Snake snake = new Snake(WIDTH / 2, HEIGHT / 2);
        Window window = new Window(snake, WIDTH, HEIGHT);

        while(true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException ie) {
                System.out.println("Timer interrupted.");
            }
            snake.move();
            window.update();
        }
    }
}
