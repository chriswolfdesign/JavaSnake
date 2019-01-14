package model;

import java.util.Random;

/**
 * Apple.java
 *
 * The class to represent the apple for our snake game.
 *
 * @author Chris Wolf
 * @version 1.0.0 (January 13, 2019)
 *
 * chriswolfdesign@gmail.com
 */

public class Apple {
    private int x;
    private int y;

    public Apple(int width, int height) {
        Random rand = new Random();
        this.x = rand.nextInt(width / 10 - 1) * 10;
        this.y = rand.nextInt(height / 10 - 1) * 10;
    }

    /**
     * Getter for our x-value
     *
     * @return {int} -- the x-value for our apple
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter for our y-value
     *
     * @return {int} -- the y-value for our apple
     */
    public int getY() {
        return this.y;
    }
}
