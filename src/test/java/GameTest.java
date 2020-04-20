import Model.Elements.Hero;
import Model.Game.Level;

import Model.Game.Position;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void levelTest(){
        Level newLevel = new Level(1);
        assertEquals(1, newLevel.getLevelNumber());
    }

    @Test
    public void elementPositionTest() {
        Position elementPos1 = new Position(0,1);

        assertEquals(elementPos1.getX(), 0);
        assertEquals(elementPos1.getY(), 1);

        elementPos1.setX(3);
        elementPos1.setY(4);

        assertEquals(elementPos1.getX(), 3);
        assertEquals(elementPos1.getY(), 4);

        Hero elementModel1 = new Hero(elementPos1);

        assertEquals(elementModel1.getPosition(), elementPos1);
        assertEquals(elementModel1.getPosition().getX(), elementPos1.getX());
        assertEquals(elementModel1.getPosition().getY(), elementPos1.getY());
    }
}