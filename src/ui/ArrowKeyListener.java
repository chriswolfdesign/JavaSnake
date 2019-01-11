package ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Snake;

public class ArrowKeyListener implements KeyListener {
    private Snake snake;

    public ArrowKeyListener(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()) {
            case KeyEvent.VK_UP:
                snake.goUp();
                break;
            case KeyEvent.VK_DOWN:
                snake.goDown();
                break;
            case KeyEvent.VK_RIGHT:
                snake.goRight();
                break;
            case KeyEvent.VK_LEFT:
                snake.goLeft();
                break;
            default:
                // Do nothing
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        // Do nothing
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        // Do nothing
    }
}
