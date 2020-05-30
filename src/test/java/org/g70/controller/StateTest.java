package org.g70.controller;

import com.googlecode.lanterna.screen.Screen;
import org.g70.controller.state.StateGame;
import org.g70.controller.state.StateGameOver;
import org.g70.controller.state.StateHelp;
import org.g70.controller.state.StateMainMenu;
import org.g70.view.ScreenView;
import org.g70.view.game.GeneralView;
import org.g70.view.handler.KeyHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class StateTest {
    private MainController controllerMock;

    @Before
    public void initController() {
        Screen screenMock = Mockito.mock(Screen.class);

        ScreenView screenViewMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenViewMock.getScreen()).thenReturn(screenMock);


        controllerMock = Mockito.spy(new MainController(screenViewMock) {
            @Override
            public ScreenView getGui() {
                return screenViewMock;
            }
        });
    }

    @Test
    public void stateMainMenuTest() throws IOException {
        StateMainMenu menuTest = new StateMainMenu(controllerMock);

        Assert.assertNotNull(menuTest.getView());

        GeneralView viewMock = Mockito.mock(GeneralView.class);
        Mockito.when(viewMock.handler()).thenReturn(KeyHandler.KEY.CLOSE);

        menuTest.setView(viewMock);
        Assert.assertEquals(menuTest.getView(), viewMock);

        menuTest.run();
        Mockito.verify(viewMock, Mockito.times(1)).handler();
    }

    @Test
    public void stateGameTest() throws IOException {
        StateGame gameTest = new StateGame(controllerMock);

        Assert.assertNotNull(gameTest.getView());

        GeneralView viewMock = Mockito.mock(GeneralView.class);
        Mockito.when(viewMock.handler()).thenReturn(KeyHandler.KEY.CLOSE);

        gameTest.setView(viewMock);
        Assert.assertEquals(viewMock, gameTest.getView());

        gameTest.run();
        Mockito.verify(viewMock, Mockito.times(1)).handler();

        Assert.assertTrue(controllerMock.getState() instanceof StateGameOver);
    }

    @Test
    public void stateGameOverTest() throws IOException {
        StateGameOver gameOverTest = new StateGameOver(controllerMock, 0);

        Assert.assertNotNull(gameOverTest.getView());

        GeneralView viewMock = Mockito.mock(GeneralView.class);
        Mockito.when(viewMock.handler()).thenReturn(KeyHandler.KEY.CLOSE);

        gameOverTest.setView(viewMock);
        Assert.assertEquals(viewMock, gameOverTest.getView());

        gameOverTest.run();
        Mockito.verify(viewMock, Mockito.times(1)).handler();
    }

    @Test
    public void stateHelpTest() throws IOException {
        StateHelp menuHelpTest = new StateHelp(controllerMock);

        Assert.assertNotNull(menuHelpTest.getView());

        GeneralView viewMock = Mockito.mock(GeneralView.class);
        Mockito.when(viewMock.handler()).thenReturn(KeyHandler.KEY.CLOSE);

        menuHelpTest.setView(viewMock);
        Assert.assertEquals(viewMock, menuHelpTest.getView());

        menuHelpTest.run();
        Mockito.verify(viewMock, Mockito.times(1)).handler();
    }
}
