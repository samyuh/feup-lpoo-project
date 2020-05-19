package controller;

import controller.level.movement.PuffleMovement;
import model.Position;
import model.drawable.element.Puffle;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PuffleMovementTest {

    @Test
    public void elementsTest() {
        Position positionMock = Mockito.mock(Position.class);
        Mockito.when(positionMock.getX()).thenReturn(1);
        Mockito.when(positionMock.getY()).thenReturn(1);

        Puffle puffleMock = Mockito.mock(Puffle.class);
        Mockito.when(puffleMock.getPosition()).thenReturn(positionMock);

        PuffleMovement heroT = new PuffleMovement(puffleMock);

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
