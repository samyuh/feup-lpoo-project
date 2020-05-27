package org.g70.controller;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.TextGUIGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.g70.controller.state.StateGameOver;
import org.g70.controller.state.StateMainMenu;
import org.junit.Test;
import org.mockito.Mockito;
import org.g70.view.ScreenView;

import java.io.IOException;

import static org.junit.Assert.*;

public class MainControllerTest {
    @Test
    public void controllerTest() throws IOException, InterruptedException {
        // Create a Stub for Screen and keyPressed
        Screen scrMock = Mockito.mock(Screen.class);
        TextGraphics txtG = Mockito.mock(TextGraphics.class);

        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);
        Mockito.when(scrMock.newTextGraphics()).thenReturn(txtG);

        // -- Main Controller
        MainController controllerTest = new MainController(screenMock);
        assertEquals(controllerTest.getState().getClass(), StateMainMenu.class);
        assertFalse(controllerTest.getExit());

        controllerTest.exit();
        assertTrue(controllerTest.getExit());

        // -- Game Over
        /*
        StateGameOver gameOverTest = new StateGameOver(controllerTest, 0);
        controllerTest.setState(gameOverTest);
        assertEquals(controllerTest.getState().getClass(), StateGameOver.class);
        */

        //gameOverTest.run();
        //assertTrue(controllerTest.getExit());
    }
}
