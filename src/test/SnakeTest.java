package test;

import model.Snake;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SnakeTest {
    Snake s;

    @Before
    public void setup() {
        s = new Snake(100, 200);
    }

    @Test
    public void testGetSize() {
        assertEquals(3, s.size(), 0.0);
    }

    @Test
    public void testAddPiece() {
        assertEquals(3, s.size(), 0.0);
        s.addPiece();
        assertEquals(4, s.size(), 0.0);
    }

    @Test
    public void testMove() {
        assertEquals(100, s.getPieces().get(0).getX(), 0.0);
        assertEquals(200, s.getPieces().get(0).getY(), 0.0);
        s.move();
        assertEquals(100, s.getPieces().get(0).getX(), 0.0);
        assertEquals(190, s.getPieces().get(0).getY(), 0.0);
    }

    @Test
    public void testGoUp() {
        assertEquals(100, s.getPieces().get(0).getX(), 0.0);
        assertEquals(200, s.getPieces().get(0).getY(), 0.0);
        s.goUp();
        s.move();
        assertEquals(100, s.getPieces().get(0).getX(), 0.0);
        assertEquals(190, s.getPieces().get(0).getY(), 0.0);
    }

    @Test
    public void testGoDown() {
        assertEquals(100, s.getPieces().get(0).getX(), 0.0);
        assertEquals(200, s.getPieces().get(0).getY(), 0.0);
        s.goDown();
        s.move();
        assertEquals(100, s.getPieces().get(0).getX(), 0.0);
        assertEquals(210, s.getPieces().get(0).getY(), 0.0);
    }

    @Test
    public void testGoRight() {
        assertEquals(100, s.getPieces().get(0).getX(), 0.0);
        assertEquals(200, s.getPieces().get(0).getY(), 0.0);
        s.goRight();
        s.move();
        assertEquals(110, s.getPieces().get(0).getX(), 0.0);
        assertEquals(200, s.getPieces().get(0).getY(), 0.0);
    }

    @Test
    public void testGoLeft() {
        assertEquals(100, s.getPieces().get(0).getX(), 0.0);
        assertEquals(200, s.getPieces().get(0).getY(), 0.0);
        s.goLeft();
        s.move();
        assertEquals(90, s.getPieces().get(0).getX(), 0.0);
        assertEquals(200, s.getPieces().get(0).getY(), 0.0);
    }
}
