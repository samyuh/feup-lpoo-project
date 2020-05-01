package Controller;

import Controller.Element.HeroMovement;
import Model.Elements.Hero;
import Model.Position;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class HeroMovementTest {

    @Test
    public void elementsTest() {
        Position positionMock = Mockito.mock(Position.class);
        Mockito.when(positionMock.getX()).thenReturn(1);
        Mockito.when(positionMock.getY()).thenReturn(1);

        Hero heroMock = Mockito.mock(Hero.class);
        Mockito.when(heroMock.getPosition()).thenReturn(positionMock);
        HeroMovement heroT = new HeroMovement(heroMock);

        assertEquals(heroT.moveUp().getX(), 1);
        assertEquals(heroT.moveUp().getY(), 0);

        assertEquals(heroT.moveDown().getX(), 1);
        assertEquals(heroT.moveDown().getY(), 2);

        assertEquals(heroT.moveRight().getX(), 2);
        assertEquals(heroT.moveRight().getY(), 1);

        assertEquals(heroT.moveLeft().getX(), 0);
        assertEquals(heroT.moveLeft().getY(), 1);

        assertTrue(heroT.atPosition(positionMock));
    }
}
