package model;

/**
 * SnakePiece.java
 *
 * A class to represent the individual pieces of the snake character
 *
 * @author Chris Wolf
 * @version 1.0.0 (January 9, 2019)
 *
 * chriswolfdesign@gmail.com
 */

public class SnakePiece {
    private int x;
    private int y;
    private static final int PIECE_SIZE = 10;

    public SnakePiece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return the size of each snake piece
     *
     * @return {int} -- the size of each snake piece
     */
    public static int getPieceSize() {
        return PIECE_SIZE;
    }

    /**
     * Getter for the snake piece's x-value
     *
     * @return {int} -- the snake piece's x-value
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter for the snake piece's y-value
     *
     * @return {int} -- the snake pieces y-value
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setter for the snake piece's x-value
     *
     * @param {int} x -- the snake piece's new x-value
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Setter for the snake piece's y-value
     *
     * @param {int} y -- the snake piece's new y-value
     */
    public void setY(int y) {
        this.y = y;
    }
}
