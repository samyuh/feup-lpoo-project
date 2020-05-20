package org.g70.controller;

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
    public void controllerTest() throws IOException {
        // Create a Stub for Screen and keyPressed
        Screen scrMock = Mockito.mock(Screen.class);
        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);

        // -- Main Controller
        MainController controllerTest = new MainController(screenMock);
        assertEquals(controllerTest.getState().getClass(), StateMainMenu.class);
        assertFalse(controllerTest.getExit());

        // -- Game Over
        StateGameOver gameOverTest = new StateGameOver(controllerTest, 0);
        controllerTest.setState(gameOverTest);
        assertEquals(controllerTest.getState().getClass(), StateGameOver.class);

        //gameOverTest.run();
        //assertTrue(controllerTest.getExit());
    }
}
