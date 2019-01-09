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
}
