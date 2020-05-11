package controller;

import com.googlecode.lanterna.screen.Screen;
import controller.state.StateMainMenu;
import org.junit.Test;
import org.mockito.Mockito;
import view.ScreenView;

import java.io.IOException;

import static org.junit.Assert.*;

public class MainControllerTest {
    @Test
    public void controllerTest() {
        // Create a Stub for Screen and keyPressed
        Screen scrMock = Mockito.mock(Screen.class);
        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);

        MainController controllerTest = new MainController(screenMock);
        assertEquals(controllerTest.getState().getClass(), StateMainMenu.class);

        assertFalse(controllerTest.getExit());

        /* Fix this
        StateGameOver gameOverTest = new StateGameOver(controllerTest);
        controllerTest.setState(gameOverTest);
        assertEquals(controllerTest.getState().getClass(), StateGameOver.class);
        gameOverTest.run();

        assertTrue(controllerTest.getExit());
         */
    }
}
