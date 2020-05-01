package Model;

import Model.Elements.Destination;
import Model.Elements.ElementModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ElementTest {
    List<ElementModel> elementMocks;

    @Test
    public void elementsTest(){
        elementMocks = new ArrayList<>();
        Position positionMock = mock(Position.class);
        when(positionMock.getX()).thenReturn(1);
        when(positionMock.getY()).thenReturn(2);

        ElementModel elementMock = new Destination(positionMock);

        assertEquals(elementMock.getPosition().getX(), 1);
        assertEquals(elementMock.getPosition().getY(), 2);
    }
}
