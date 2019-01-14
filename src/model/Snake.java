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
    private int width;
    private int height;
    private int dx;
    private int dy;
    private Direction direction;

    public Snake(int width, int height) {
        this.width = width;
        this.height = height;

        int firstX = width / 2;
        int firstY = height / 2;

        pieces = new ArrayList<>();
        direction = Direction.UP; 

        for (int i = 0; i < 3; i++) {
            pieces.add(new SnakePiece(firstX, firstY + SnakePiece.getPieceSize() * i));
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
     * Getter for direction field
     *
     * @return {Direction} -- the direction the snake is currently going
     */
    public Direction getDirection() {
        return direction;
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
        if (direction != Direction.DOWN) {
            direction = Direction.UP;
            this.dx = 0;
            this.dy = -1 * SnakePiece.getPieceSize();
        }
    }

    /**
     * Sets the dx and dy values such that the snake will be moving down.
     */
    public void goDown() {
        if (direction != Direction.UP) {
            direction = Direction.DOWN;
            this.dx = 0;
            this.dy = SnakePiece.getPieceSize();
        }
    }

    /**
     * Sets the dx and dy values such that the snake will be moving right.
     */
    public void goRight() {
        if (direction != Direction.LEFT) {
            direction = Direction.RIGHT;
            this.dx = SnakePiece.getPieceSize();
            this.dy = 0;
        }
    }

    /**
     * Sets the dx and dy values such that the snake will be moving left.
     */
    public void goLeft() {
        if (direction != Direction.RIGHT) {
            direction = Direction.LEFT;
            this.dx = -1 * SnakePiece.getPieceSize();
            this.dy = 0;
        }
    }

    /**
     * Determines whether or not the snake is out of bounds
     *
     * @return {boolean} -- true if the snake is out of bounds, false if it is not
     */
    public boolean outOfBounds() {
        return (pieces.get(0).getX() < 0) || (pieces.get(0).getX() > width) ||
               (pieces.get(0).getY() < 0) || (pieces.get(0).getY() > height);
    }

    /**
     * Determines whether or not the snake is currently touching an apple
     *
     * @param {Apple} apple -- the apple we are testing for collision
     *
     * @return {boolean} -- true if the snake is touching the apple, false otherwise
     */
    public boolean isTouchingApple(Apple apple) {
        for(SnakePiece piece : pieces) {
            if(piece.getX() == apple.getX() && piece.getY() == apple.getY()) {
                return true;
            }
        }

        return false;
    }
}
