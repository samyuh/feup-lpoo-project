package org.g70.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.g70.model.Position;
import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.element.immovable.Wall;
import org.g70.model.drawable.element.movable.Puffle;
import org.g70.model.level.LevelHeaderModel;
import org.g70.model.level.LevelModel;
import org.g70.view.ScreenView;
import org.g70.view.handler.KeyHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LevelViewTest {
    private List<Drawable> elementMocks;

    private TextGraphics graphicsMock;
    private Screen scrMock;
    private LevelView levelView;

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

        // Mocks
        graphicsMock = Mockito.mock(TextGraphics.class);

        scrMock = Mockito.mock(Screen.class);
        Mockito.when(scrMock.newTextGraphics()).thenReturn(graphicsMock);

        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);

        LevelModel levelMock = Mockito.mock(LevelModel.class);
        Mockito.when(levelMock.getAll()).thenReturn(this.elementMocks);

        LevelHeaderModel headerMock = Mockito.mock(LevelHeaderModel.class);

        levelView = new LevelView(screenMock, levelMock, headerMock);
    }

    @Test
    public void drawTest() throws IOException {
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

        Mockito.verify(scrMock, Mockito.times(1)).clear();
        Mockito.verify(scrMock, Mockito.times(1)).refresh();
    }

    @Test
    public void testHandler() throws IOException {
        KeyStroke keyEOF = Mockito.mock(KeyStroke.class);
        Mockito.when(keyEOF.getKeyType()).thenReturn(KeyType.EOF);
        Mockito.when(scrMock.readInput()).thenReturn(keyEOF);
        Assert.assertEquals(levelView.handler(), KeyHandler.KEY.CLOSE);
    }
}
