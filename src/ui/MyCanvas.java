package ui;

import model.Snake;
import model.SnakePiece;
import model.Apple;

import java.awt.*;

public class MyCanvas extends Canvas {
    private Snake snake;
    private Apple apple;

    public MyCanvas(Snake snake, Apple apple) {
        super();
        this.snake = snake;
        this.apple = apple;
    }

    /**
     * Getter for our apple
     *
     * @return {Apple} -- the apple for our game
     */
    public Apple getApple() {
        return this.apple;
    }
    
    /**
     * Setter for our apple
     *
     * @param {Apple} apple -- the new apple for our game
     */
    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public void paint(Graphics g) {

        g.setColor(Color.GREEN);

        for(SnakePiece piece : snake.getPieces()) {
            g.fillRect(piece.getX(), piece.getY(),
                    SnakePiece.getPieceSize(), SnakePiece.getPieceSize());
        }

        g.setColor(Color.RED);
        g.fillRect(apple.getX(), apple.getY(),
                SnakePiece.getPieceSize(), SnakePiece.getPieceSize());
    }
}
