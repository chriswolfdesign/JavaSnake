package ui;

import model.Snake;
import model.SnakePiece;

import java.awt.*;

public class MyCanvas extends Canvas {
    private Snake snake;

    public MyCanvas(Snake snake) {
        super();
        this.snake = snake;
    }

    public void paint(Graphics g) {

        g.setColor(Color.GREEN);

        for(SnakePiece piece : snake.getPieces()) {
            g.fillRect(piece.getX(), piece.getY(),
                    SnakePiece.getPieceSize(), SnakePiece.getPieceSize());
        }
    }
}
