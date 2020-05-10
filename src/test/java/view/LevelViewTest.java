package View;

import Model.Elements.ElementModel;
import Model.Elements.Puffle;
import Model.Elements.Wall;
import Model.Level.LevelModel;
import Model.Position;
import View.Level.LevelView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LevelViewTest {
    List<ElementModel> elementMocks;

    @Before
    public void startLevel() {
        elementMocks = new ArrayList<>();

        Position p1 = Mockito.mock(Position.class);
        Mockito.when(p1.getX()).thenReturn(0);
        Mockito.when(p1.getY()).thenReturn(0);

        Wall e1 = Mockito.mock(Wall.class);
        Mockito.when(e1.getImage()).thenReturn("\u2588");
        Mockito.when(e1.getColor()).thenReturn("#0065c6");
        Mockito.when(e1.getPosition()).thenReturn(p1);

        elementMocks.add(e1);

        Position p2 = Mockito.mock(Position.class);
        Mockito.when(p2.getX()).thenReturn(1);
        Mockito.when(p2.getY()).thenReturn(0);

        Puffle e2 = Mockito.mock(Puffle.class);
        Mockito.when(e2.getImage()).thenReturn("H");
        Mockito.when(e2.getColor()).thenReturn("#000000");
        Mockito.when(e2.getPosition()).thenReturn(p2);

        elementMocks.add(e2);
    }

    @Test
    public void drawTest() {
        // Create a Stub for Screen
        Screen scrMock = Mockito.mock(Screen.class);
        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);

        // Create a levelMock with the elements that will appear on screen
        LevelModel levelMock = Mockito.mock(LevelModel.class);
        Mockito.when(levelMock.getAll()).thenReturn(this.elementMocks);

        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);

        LevelView levelView = new LevelView(screenMock);
        levelView.drawLevel(levelMock, graphicsMock);

        Mockito.verify(graphicsMock, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#8dc5f0"));

        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#0065c6"));
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(0, 0), "\u2588");

        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(1, 0), "H");
    }

    @Test
    public void inputTest() throws IOException {
        // Create a Stub for Screen and keyPressed
        Screen scrMock = Mockito.mock(Screen.class);
        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);

        KeyStroke keyUp = Mockito.mock(KeyStroke.class);
        Mockito.when(keyUp.getKeyType()).thenReturn(KeyType.ArrowUp);

        KeyStroke keyRight = Mockito.mock(KeyStroke.class);
        Mockito.when(keyRight.getKeyType()).thenReturn(KeyType.ArrowRight);

        KeyStroke keyDown = Mockito.mock(KeyStroke.class);
        Mockito.when(keyDown.getKeyType()).thenReturn(KeyType.ArrowDown);

        KeyStroke keyLeft = Mockito.mock(KeyStroke.class);
        Mockito.when(keyLeft.getKeyType()).thenReturn(KeyType.ArrowLeft);

        KeyStroke keyEOF = Mockito.mock(KeyStroke.class);
        Mockito.when(keyEOF.getKeyType()).thenReturn(KeyType.EOF);

        LevelView levelView = new LevelView(screenMock);

        Mockito.when(scrMock.readInput()).thenReturn(keyUp);
        assertEquals(KeyHandler.processKey(scrMock), KeyHandler.DIRECTION.UP);

        Mockito.when(scrMock.readInput()).thenReturn(keyRight);
        assertEquals(KeyHandler.processKey(scrMock), KeyHandler.DIRECTION.RIGHT);

        Mockito.when(scrMock.readInput()).thenReturn(keyDown);
        assertEquals(KeyHandler.processKey(scrMock), KeyHandler.DIRECTION.DOWN);

        Mockito.when(scrMock.readInput()).thenReturn(keyLeft);
        assertEquals(KeyHandler.processKey(scrMock), KeyHandler.DIRECTION.LEFT);

        Mockito.when(scrMock.readInput()).thenReturn(keyEOF);
        assertEquals(KeyHandler.processKey(scrMock), KeyHandler.DIRECTION.CLOSE);
    }
}
