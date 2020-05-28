package org.g70.controller.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.g70.controller.MainController;
import org.g70.controller.menu.option.OptionExit;
import org.g70.controller.menu.option.OptionHelp;
import org.g70.controller.menu.option.OptionMainMenu;
import org.g70.controller.menu.option.OptionNewGame;
import org.g70.controller.state.StateGame;
import org.g70.controller.state.StateHelp;
import org.g70.controller.state.StateMainMenu;
import org.g70.view.ScreenView;
import org.g70.view.game.GeneralView;
import org.g70.view.handler.KeyHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class OptionControllerTest {
    MainController controller;

    @Before
    public void initController() {
        Screen screenMock = Mockito.mock(Screen.class);

        ScreenView screenViewMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenViewMock.getScreen()).thenReturn(screenMock);

        controller = new MainController(screenViewMock);
    }

    @Test
    public void optionExitTest() {
        OptionExit optionTest = new OptionExit(controller);

        Assert.assertFalse(controller.getExit());
        optionTest.execute();
        Assert.assertTrue(controller.getExit());
    }

    @Test
    public void optionHelpTest() {
        OptionHelp optionTest = new OptionHelp(controller);

        Assert.assertTrue(controller.getState() instanceof StateMainMenu);
        optionTest.execute();
        Assert.assertTrue(controller.getState() instanceof StateHelp);
    }

    @Test
    public void optionMainMenuTest() {
        OptionMainMenu optionTest = new OptionMainMenu(controller);

        StateHelp mockHelp = Mockito.mock(StateHelp.class);
        controller.setState(mockHelp);

        Assert.assertTrue(controller.getState() instanceof StateHelp);
        optionTest.execute();
        Assert.assertTrue(controller.getState() instanceof StateMainMenu);
    }

    @Test
    public void optionNewGameTest() {
        OptionNewGame optionTest = new OptionNewGame(controller);

        Assert.assertTrue(controller.getState() instanceof StateMainMenu);
        optionTest.execute();
        Assert.assertTrue(controller.getState() instanceof StateGame);
    }
}
