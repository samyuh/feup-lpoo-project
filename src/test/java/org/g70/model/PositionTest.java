package Model;

import org.g70.model.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {
    @Test
    public void positionTest() {
        Position elementPos1 = new Position(0,1);
        Position elementPos2 = new Position(5,7);

        assertEquals(elementPos1.getX(), 0);
        assertEquals(elementPos1.getY(), 1);
        assertEquals(elementPos2.getX(), 5);
        assertEquals(elementPos2.getY(), 7);

        elementPos1.setX(3);
        elementPos1.setY(4);
        elementPos2.setX(3);
        elementPos2.setY(4);

        assertEquals(elementPos1.getX(), 3);
        assertEquals(elementPos1.getY(), 4);
        assertEquals(elementPos2.getX(), 3);
        assertEquals(elementPos2.getY(), 4);


        elementPos1.moveUp();
        elementPos2.moveDown();

        assertEquals(elementPos1.getX(), 3);
        assertEquals(elementPos1.getY(), 3);
        assertEquals(elementPos2.getX(), 3);
        assertEquals(elementPos2.getY(), 5);

        elementPos1.moveRight();
        elementPos2.moveLeft();

        assertEquals(elementPos1.getX(), 4);
        assertEquals(elementPos1.getY(), 3);
        assertEquals(elementPos2.getX(), 2);
        assertEquals(elementPos2.getY(), 5);

        Position elementPos3 = new Position(5,7);
        Position elementPos4 = new Position(5,7);

        assertTrue(elementPos4.equals(elementPos3));
    }
}