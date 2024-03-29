package org.g70.view.drawable;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import org.g70.model.Position;
import org.g70.model.drawable.element.ElementModel;
import org.junit.Test;
import org.mockito.Mockito;

public class DrawableViewTest {
    @Test
    public void drawTest() {
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);

        DrawableView elementView = new DrawableView();

        Position positionMock = Mockito.mock(Position.class);
        Mockito.when(positionMock.getX()).thenReturn(0);
        Mockito.when(positionMock.getY()).thenReturn(0);

        ElementModel elementMock = Mockito.mock(ElementModel.class);
        Mockito.when(elementMock.getPosition()).thenReturn(positionMock);
        Mockito.when(elementMock.getColorForeground()).thenReturn("#FFBB33");
        Mockito.when(elementMock.getImage()).thenReturn("I");

        elementView.draw(elementMock, graphicsMock);

        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFBB33"));
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(0, 0), "I");
    }
}
