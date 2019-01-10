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
    private int dx;
    private int dy;

    public Snake(int x, int y) {
        pieces = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            pieces.add(new SnakePiece(x, y + SnakePiece.getPieceSize() * i));
        }

        // Begin with the snake moving up
        dx = 0;
        dy = -1 * SnakePiece.getPieceSize();
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
     * Adds a piece to the end of our snake
     * (placing it below the most recent piece)
     */
    public void addPiece() {
        this.pieces.add(new SnakePiece(pieces.get(this.size() - 1).getX(),
                pieces.get(this.size() - 1).getY() +
                        SnakePiece.getPieceSize()));
    }

    /**
     * Causes the Snake to move one "pixel" based on the current
     * dx and dy values
     */
    public void move() {
        // Put all pieces of the snake where the previous piece was
        for (int i = this.size() - 1; i > 0; i--) {
            this.pieces.get(i).setX(this.pieces.get(i - 1).getX());
            this.pieces.get(i).setY(this.pieces.get(i - 1).getY());
        }

        // Move the head of the snake based on the current dx and dy values
        this.pieces.get(0).setX(this.pieces.get(0).getX() + this.dx);
        this.pieces.get(0).setY(this.pieces.get(0).getY() + this.dy);
    }

    /**
     * Sets the dx and dy values such that the snake will be moving up.
     */
    public void goUp() {
        this.dx = 0;
        this.dy = -1 * SnakePiece.getPieceSize();
    }

    /**
     * Sets the dx and dy values such that the snake will be moving down.
     */
    public void goDown() {
        this.dx = 0;
        this.dy = SnakePiece.getPieceSize();
    }

    /**
     * Sets the dx and dy values such that the snake will be moving right.
     */
    public void goRight() {
        this.dx = SnakePiece.getPieceSize();
        this.dy = 0;
    }

    /**
     * Sets the dx and dy values such that the snake will be moving left.
     */
    public void goLeft() {
        this.dx = -1 * SnakePiece.getPieceSize();
        this.dy = 0;
    }
}
