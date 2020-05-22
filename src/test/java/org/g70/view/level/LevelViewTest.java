package org.g70.view.level;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.g70.model.Position;
import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.element.Puffle;
import org.g70.model.drawable.element.Wall;
import org.g70.model.level.LevelHeaderModel;
import org.g70.model.level.LevelModel;
import org.g70.view.ScreenView;
import org.g70.view.game.LevelView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LevelViewTest {
    List<Drawable> elementMocks;

    @Before
    public void startLevel() {
        elementMocks = new ArrayList<>();

        Position p1 = Mockito.mock(Position.class);
        Mockito.when(p1.getX()).thenReturn(0);
        Mockito.when(p1.getY()).thenReturn(0);

        Wall e1 = Mockito.mock(Wall.class);
        Mockito.when(e1.getImage()).thenReturn("\u2588");
        Mockito.when(e1.getColorForeground()).thenReturn("#0065c6");
        Mockito.when(e1.getPosition()).thenReturn(p1);

        elementMocks.add(e1);

        Position p2 = Mockito.mock(Position.class);
        Mockito.when(p2.getX()).thenReturn(1);
        Mockito.when(p2.getY()).thenReturn(0);

        Puffle e2 = Mockito.mock(Puffle.class);
        Mockito.when(e2.getImage()).thenReturn("H");
        Mockito.when(e2.getColorForeground()).thenReturn("#000000");
        Mockito.when(e2.getPosition()).thenReturn(p2);

        elementMocks.add(e2);
    }

    @Test
    public void drawTest() {
        // Create a Stub for Screen
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);

        Screen scrMock = Mockito.mock(Screen.class);
        Mockito.when(scrMock.newTextGraphics()).thenReturn(graphicsMock);

        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);

        // Create a levelMock with the elements that will appear on screen
        LevelModel levelMock = Mockito.mock(LevelModel.class);
        Mockito.when(levelMock.getAll()).thenReturn(this.elementMocks);

        LevelHeaderModel headerMock = Mockito.mock(LevelHeaderModel.class);

        LevelView levelView = new LevelView(screenMock, levelMock, headerMock);

        try {
            levelView.draw();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Mockito.verify(graphicsMock, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#8dc5f0"));

        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#0065c6"));
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(0, 0), "\u2588");

        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(1, 0), "H");
    }
}
