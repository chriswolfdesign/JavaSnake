package test;

import model.Snake;
import model.Direction;
import model.Apple;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SnakeTest {
    Snake s;
    Apple a;

    @Before
    public void setup() {
        s = new Snake(200, 400);
        a = new Apple(200, 400);
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
        s.goRight();
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

    @Test
    public void testGoingFromUpToDown() {
        s.goUp();
        assertEquals(s.getDirection(), Direction.UP);
        s.goDown();
        assertEquals(s.getDirection(), Direction.UP);
    }

    @Test
    public void testGoingFromDownToUp() {
        s.goRight();
        s.goDown();
        assertEquals(s.getDirection(), Direction.DOWN);
        s.goUp();
        assertEquals(s.getDirection(), Direction.DOWN);
    }

    @Test
    public void testGoingFromLeftToRight() {
        s.goLeft();
        assertEquals(s.getDirection(), Direction.LEFT);
        s.goRight();
        assertEquals(s.getDirection(), Direction.LEFT);
    }

    @Test
    public void testGoingFromRightToLeft() {
        s.goRight();
        assertEquals(s.getDirection(), Direction.RIGHT);
        s.goLeft();
        assertEquals(s.getDirection(), Direction.RIGHT);
    }

    @Test
    public void testOutOfBounds_IsInBounds() {
        s.getPieces().get(0).setX(50);
        s.getPieces().get(0).setY(50);
        assertFalse(s.outOfBounds());
    }

    @Test
    public void testOutOfBounds_IsAboveFrame() {
        s.getPieces().get(0).setX(50);
        s.getPieces().get(0).setY(-50);
        assertTrue(s.outOfBounds());
    }

    @Test
    public void testOutOfBounds_IsBelowFrame() {
        s.getPieces().get(0).setX(50);
        s.getPieces().get(0).setY(450);
        assertTrue(s.outOfBounds());
    }

    @Test
    public void testOutOfBounds_IsLeftOfFrame() {
        s.getPieces().get(0).setX(-50);
        s.getPieces().get(0).setY(50);
        assertTrue(s.outOfBounds());
    }

    @Test
    public void testOutOfBounds_IsRightOfFrame() {
        s.getPieces().get(0).setX(250);
        s.getPieces().get(0).setY(50);
        assertTrue(s.outOfBounds());
    }

    @Test
    public void testIsTouchingApple_isTouching() {
        a.setX(100);
        a.setY(200);
        assertTrue(s.isTouchingApple(a));
    }

    @Test
    public void testIsTouchingApple_isBelowApple() {
        a.setX(100);
        a.setY(190);
        assertFalse(s.isTouchingApple(a));
    }

    @Test
    public void testIsTouchingApple_isAboveApple() {
        a.setX(100);
        a.setY(250);
        assertFalse(s.isTouchingApple(a));
    }

    @Test
    public void testIsTouchingApple_isRightOfApple() {
        a.setX(90);
        a.setY(200);
        assertFalse(s.isTouchingApple(a));
    }

    @Test
    public void testIsTouchingApple_isLeftOfApple() {
        a.setX(110);
        a.setY(200);
        assertFalse(s.isTouchingApple(a));
    }
}
