package org.g70.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.g70.model.Position;
import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.menudrawable.MenuOption;
import org.g70.model.menu.MenuFactory;
import org.g70.view.ScreenView;
import org.g70.view.handler.KeyHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuViewTest {
    private List<Drawable> textBoxes;
    private List<MenuOption> options;

    private MenuView menuView;
    private TextGraphics graphicsMock;
    private Screen scrMock;

    @Before
    public void startLevel() {
        options = new ArrayList<>();
        textBoxes = new ArrayList<>();

        Position p1 = Mockito.mock(Position.class);
        Mockito.when(p1.getX()).thenReturn(0);
        Mockito.when(p1.getY()).thenReturn(0);

        MenuOption e1 = Mockito.mock(MenuOption.class);
        Mockito.when(e1.getImage()).thenReturn("Option");
        Mockito.when(e1.getColorForeground()).thenReturn("#0065c6");
        Mockito.when(e1.getPosition()).thenReturn(p1);

        options.add(e1);

        Position p2 = Mockito.mock(Position.class);
        Mockito.when(p2.getX()).thenReturn(2);
        Mockito.when(p2.getY()).thenReturn(1);

        Drawable e2 = Mockito.mock(Drawable.class);
        Mockito.when(e2.getImage()).thenReturn("This is a test string");
        Mockito.when(e2.getColorBackground()).thenReturn("#ffffff");
        Mockito.when(e2.getColorForeground()).thenReturn("#000077");
        Mockito.when(e2.getPosition()).thenReturn(p2);

        textBoxes.add(e2);

        // Mocks
        graphicsMock = Mockito.mock(TextGraphics.class);

        scrMock = Mockito.mock(Screen.class);
        Mockito.when(scrMock.newTextGraphics()).thenReturn(graphicsMock);

        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);

        // Create a menuMock with the elements that will appear on screen
        MenuFactory menuMock = Mockito.mock(MenuFactory.class);
        Mockito.when(menuMock.getOptions()).thenReturn(this.options);
        Mockito.when(menuMock.getTextBoxes()).thenReturn(this.textBoxes);

        menuView = new MenuView(screenMock,menuMock);
    }

    @Test
    public void menuViewTest() throws IOException {
        try {
            menuView.draw();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#0065c6"));
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(0, 0), "Option");

        Mockito.verify(graphicsMock, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#ffffff"));
        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#000077"));
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(2, 1), "This is a test string");

        Mockito.verify(scrMock, Mockito.times(1)).clear();
        Mockito.verify(scrMock, Mockito.times(1)).refresh();

        KeyStroke keyEOF = Mockito.mock(KeyStroke.class);
        Mockito.when(keyEOF.getKeyType()).thenReturn(KeyType.EOF);
        Mockito.when(scrMock.readInput()).thenReturn(keyEOF);
        Assert.assertEquals(menuView.handler(), KeyHandler.KEY.CLOSE);
    }

    @Test
    public void testHandler() throws IOException {
        KeyStroke keyEOF = Mockito.mock(KeyStroke.class);
        Mockito.when(keyEOF.getKeyType()).thenReturn(KeyType.EOF);
        Mockito.when(scrMock.readInput()).thenReturn(keyEOF);
        Assert.assertEquals(menuView.handler(), KeyHandler.KEY.CLOSE);
    }
}
