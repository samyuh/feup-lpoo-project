package org.g70.model.drawable;

import org.g70.model.Position;
import org.g70.model.drawable.element.Finish;
import org.g70.model.drawable.element.ElementModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ElementTest {
    @Test
    public void elementsTest() {
        Position positionMock = mock(Position.class);
        when(positionMock.getX()).thenReturn(1);
        when(positionMock.getY()).thenReturn(2);

        ElementModel element = new Finish(positionMock);

        assertEquals(element.getPosition().getX(), 1);
        assertEquals(element.getPosition().getY(), 2);
        assertEquals(element.getImage(), "D");
        assertEquals(element.getColorForeground(), "#ff0422");
    }
}
