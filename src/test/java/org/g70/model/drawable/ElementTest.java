package org.g70.model.drawable;

import org.g70.model.Position;
import org.g70.model.drawable.element.Box;
import org.g70.model.drawable.element.Finish;
import org.g70.model.drawable.element.ElementModel;
import org.g70.model.drawable.element.Puffle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ElementTest {
    Position positionMock;

    @Before
    public void initPosition() {
        positionMock = mock(Position.class);
        when(positionMock.getX()).thenReturn(1);
        when(positionMock.getY()).thenReturn(2);
    }

    @Test
    public void elementFinish() {
        Finish element = new Finish(positionMock);

        assertEquals(element.getPosition().getX(), 1);
        assertEquals(element.getPosition().getY(), 2);
        assertEquals(element.getImage(), "D");
        assertEquals(element.getColorForeground(), "#ff0422");
    }

    @Test
    public void elementPuffle() {
        Puffle element = new Puffle(positionMock);

        assertEquals(element.getPosition().getX(), 1);
        assertEquals(element.getPosition().getY(), 2);
        assertEquals(element.getImage(), "\u25CF");
        assertEquals(element.getColorForeground(), "#ff0422");
    }

    @Test
    public void elementBox() {
        Box element = new Box(positionMock);

        assertEquals(element.getPosition().getX(), 1);
        assertEquals(element.getPosition().getY(), 2);
        assertEquals(element.getImage(), "O");
        assertEquals(element.getColorForeground(), "#0079d0");
    }
}
