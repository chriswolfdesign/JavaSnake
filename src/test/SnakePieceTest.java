package test;

import model.SnakePiece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * SnakePieceTest.java
 *
 * Unit Testing for SnakePiece.java
 */

public class SnakePieceTest {
    SnakePiece sp;

    @Before
    public void setup() {
        sp = new SnakePiece(5, 10);
    }

    @Test
    public void testGetX() {
        assertEquals(5, sp.getX(), 0.0);
    }

    @Test
    public void testGetY() {
        assertEquals(10, sp.getY(), 0.0);
    }

    @Test
    public void testSetX() {
        sp.setX(100);
        assertEquals(100, sp.getX(), 0.0);
    }

    @Test
    public void testSetY() {
        sp.setY(200);
        assertEquals(200, sp.getY(), 0.0);
    }

    @Test
    public void testGetPieceSize() {
        assertEquals(10, SnakePiece.getPieceSize(), 0.0);
    }
}
