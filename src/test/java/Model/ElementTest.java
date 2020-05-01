package Model;

import Model.Elements.Destination;
import Model.Elements.ElementModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ElementTest {
    @Test
    public void elementsTest(){
        Position positionMock = mock(Position.class);
        when(positionMock.getX()).thenReturn(1);
        when(positionMock.getY()).thenReturn(2);

        ElementModel elementMock = new Destination(positionMock);

        assertEquals(elementMock.getPosition().getX(), 1);
        assertEquals(elementMock.getPosition().getY(), 2);

        // Literally, spaguetti code but whatever
    }
}
