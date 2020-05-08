package Controller;

import Controller.State.StateGame;
import Controller.State.StateGameOver;
import Controller.State.StateMainMenu;
import View.ScreenView;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.*;

public class MainControllerTest {
    @Test
    public void controllerTest() throws IOException {
        // Create a Stub for Screen and keyPressed
        Screen scrMock = Mockito.mock(Screen.class);
        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);

        MainController controllerTest = new MainController(screenMock);
        assertEquals(controllerTest.getState().getClass(), StateMainMenu.class);

        assertFalse(controllerTest.getExit());

        StateGameOver gameOverTest = new StateGameOver(controllerTest);
        controllerTest.setState(gameOverTest);
        assertEquals(controllerTest.getState().getClass(), StateGameOver.class);
        gameOverTest.run();

        assertTrue(controllerTest.getExit());
    }
}
