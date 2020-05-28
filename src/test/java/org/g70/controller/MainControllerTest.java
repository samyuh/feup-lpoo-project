package org.g70.controller;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.TextGUIGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.g70.controller.state.State;
import org.g70.controller.state.StateGame;
import org.g70.controller.state.StateGameOver;
import org.g70.controller.state.StateMainMenu;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.g70.view.ScreenView;

import java.io.IOException;

import static org.junit.Assert.*;

public class MainControllerTest {
    @Test
    public void controllerTest() throws IOException, InterruptedException {
        // Create a Stub
        Screen scrMock = Mockito.mock(Screen.class);
        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);

        MainController controllerTest = new MainController(screenMock);
        assertTrue(controllerTest.getState() instanceof StateMainMenu);
        assertNotNull(controllerTest.getGui());
        assertNotNull(controllerTest.getState());
        assertFalse(controllerTest.getExit());

        StateGame mock = Mockito.mock(StateGame.class);

        Mockito.doAnswer(invocation -> {
            controllerTest.exit();
            return null;
        }).when(mock).run();
        

        controllerTest.setState(mock);
        controllerTest.run();
        Mockito.verify(mock, Mockito.times(1)).run();
    }

    @Test
    public void controllerExit() throws IOException, InterruptedException {
        // Create a Stub
        Screen scrMock = Mockito.mock(Screen.class);
        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);

        // -- Main Controller Exit Test -- //
        MainController controllerTest = new MainController(screenMock);
        assertEquals(controllerTest.getState().getClass(), StateMainMenu.class);
        assertNotNull(controllerTest.getGui());
        assertNotNull(controllerTest.getState());
        assertFalse(controllerTest.getExit());

        StateGame mock = Mockito.mock(StateGame.class);

        controllerTest.setState(mock);
        controllerTest.exit();
        assertTrue(controllerTest.getExit());

        controllerTest.run();
        Mockito.verify(mock, Mockito.times(0)).run();
    }
}
