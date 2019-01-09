package model;

import java.util.ArrayList;

/**
 * Snake.java
 *
 * The class that will represent the snake character in our game.
 *
 * @author Chris Wolf
 * @version 1.0.0 (January 9, 2019)
 *
 * chriswolfdesign@gmail.com
 */

public class Snake {
    private ArrayList<SnakePiece> pieces;

    public Snake(int x, int y) {
        pieces = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            pieces.add(new SnakePiece(x, y + SnakePiece.getPieceSize() * i));
        }
    }

    /**
     * Getter for pieces field
     *
     * @return {ArrayList<SnakePiece>} -- the list of snake pieces
     */
    public ArrayList<SnakePiece> getPieces() {
        return this.pieces;
    }

    /**
     * Returns the size of our snake (length of the piece's list)
     *
     * @return {int} -- the size of our snake
     */
    public int size() {
        return this.pieces.size();
    }

    /**
     * Adds a piece to the end of our snake (placing it below the most recent piece)
     */
    public void addPiece() {
        this.pieces.add(new SnakePiece(pieces.get(this.size() - 1).getX(),
                pieces.get(this.size() - 1).getY() + SnakePiece.getPieceSize()));
    }
}
