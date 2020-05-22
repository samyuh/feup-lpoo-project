package org.g70.view.menu;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.g70.model.Position;
import org.g70.model.drawable.menu.MenuOption;
import org.g70.model.menu.MenuFactory;
import org.g70.view.ScreenView;
import org.g70.view.game.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuViewTest {
    List<MenuOption> options;

    @Before
    public void startLevel() {
        options = new ArrayList<>();

        Position p1 = Mockito.mock(Position.class);
        Mockito.when(p1.getX()).thenReturn(0);
        Mockito.when(p1.getY()).thenReturn(0);

        MenuOption e1 = Mockito.mock(MenuOption.class);
        Mockito.when(e1.getImage()).thenReturn("Option");
        Mockito.when(e1.getColorForeground()).thenReturn("#0065c6");
        Mockito.when(e1.getPosition()).thenReturn(p1);

        options.add(e1);
    }

    @Test
    public void drawTest() {
        // Create a Stub for Screen
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);

        Screen scrMock = Mockito.mock(Screen.class);
        Mockito.when(scrMock.newTextGraphics()).thenReturn(graphicsMock);

        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);

        // Create a menuMock with the elements that will appear on screen
        MenuFactory menuMock = Mockito.mock(MenuFactory.class);
        Mockito.when(menuMock.getOption()).thenReturn(this.options);

        MenuView menuView = new MenuView(screenMock,menuMock);

        try {
            menuView.draw();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Mockito.verify(graphicsMock, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#000077"));

        Mockito.verify(graphicsMock, Mockito.times(1)).putString(2, 1, "FrostBite Penguin Madness", SGR.BOLD);
    }
}
