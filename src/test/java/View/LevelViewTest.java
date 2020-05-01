package View;

import Model.Elements.ElementModel;
import Model.Position;
import View.Element.ElementView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class LevelViewTest {
    @Test
    public void drawTest() {
        /*
        TextGraphics graphicsMock = mock(TextGraphics.class);

        ElementView elementView = new ElementView();

        Position positionMock = mock(Position.class);
        when(positionMock.getX()).thenReturn(0);
        when(positionMock.getY()).thenReturn(0);

        ElementModel elementMock = mock(ElementModel.class);
        when(elementMock.getPosition()).thenReturn(positionMock);
        when(elementMock.getColor()).thenReturn("#FFBB33");
        when(elementMock.getImage()).thenReturn("I");

        elementView.draw(elementMock, graphicsMock);

        Mockito.verify(graphicsMock, times(1)).setForegroundColor(TextColor.Factory.fromString("#FFBB33"));
        Mockito.verify(graphicsMock, times(1)).putString(new TerminalPosition(0, 0), "I");
        */
    }
}
