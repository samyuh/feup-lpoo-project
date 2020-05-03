package View;

import Model.Elements.ElementModel;
import Model.Position;
import View.Element.ElementView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import org.junit.Test;
import org.mockito.Mockito;



public class ElementViewTest {
    @Test
    public void drawTest() {
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);

        ElementView elementView = new ElementView();

        Position positionMock = Mockito.mock(Position.class);
        Mockito.when(positionMock.getX()).thenReturn(0);
        Mockito.when(positionMock.getY()).thenReturn(0);

        ElementModel elementMock = Mockito.mock(ElementModel.class);
        Mockito.when(elementMock.getPosition()).thenReturn(positionMock);
        Mockito.when(elementMock.getColor()).thenReturn("#FFBB33");
        Mockito.when(elementMock.getImage()).thenReturn("I");

        elementView.draw(elementMock, graphicsMock);

        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFBB33"));
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(0, 0), "I");
    }
}
