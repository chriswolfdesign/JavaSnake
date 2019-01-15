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
        int score = 0;
        final int WINNING_SCORE = 50;
        Snake snake = new Snake(WIDTH, HEIGHT);
        Apple apple;

        do {
            apple = new Apple(WIDTH, HEIGHT);
        } while(snake.isTouchingApple(apple));

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

            // If the snake has touched the apple, give a point
            if(snake.isTouchingApple(apple)) {
                snake.addPiece();
                window.setSnake(snake);

                do {
                    apple = new Apple(WIDTH, HEIGHT);
                } while(snake.isTouchingApple(apple));

                window.setApple(apple);

                score++;
                System.out.println(score);
                window.setTitle("Snake -- Score: " + score);
            }

            // If the user has reached the necessary score, let them win
            if(score == WINNING_SCORE) {
                JOptionPane.showMessageDialog(window, "YOU WIN -- Thanks for playing");
                System.exit(0);
            }

            // If the snake has gone out of bounds, game over
            if(snake.outOfBounds()) {
                JOptionPane.showMessageDialog(window, "GAME OVER -- You went out of bounds :_(");
                System.exit(0);
            }

            // If the snake bit itself, game over
            if(snake.bitItself()) {
                JOptionPane.showMessageDialog(window, "GAME OVER -- The snake bit itself :_(");
                System.exit(0);
            }
        }
    }
}
