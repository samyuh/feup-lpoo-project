package View;

import Model.Elements.ElementModel;
import Model.Elements.Hero;
import Model.Elements.Wall;
import Model.Level.LevelModel;
import Model.Position;
import View.Level.LevelView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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
        Mockito.when(e1.getColor()).thenReturn("#8ABDE8");
        Mockito.when(e1.getPosition()).thenReturn(p1);

        elementMocks.add(e1);

        Position p2 = Mockito.mock(Position.class);
        Mockito.when(p2.getX()).thenReturn(1);
        Mockito.when(p2.getY()).thenReturn(0);

        Hero e2 = Mockito.mock(Hero.class);
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

        Mockito.verify(graphicsMock, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#336699"));
        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#8ABDE8"));
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(0, 0), "\u2588");

        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(1, 0), "H");

        // Continue...
    }
}
