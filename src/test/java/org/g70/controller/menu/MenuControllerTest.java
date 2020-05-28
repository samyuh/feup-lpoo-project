package org.g70.controller.menu;

import org.g70.controller.MainController;
import org.g70.controller.menu.option.Option;
import org.g70.model.menu.MainMenuModel;
import org.g70.view.game.GeneralView;
import org.g70.view.handler.KeyHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuControllerTest {
    private MainController mainControllerMock;
    private GeneralView menuViewMock;
    private MainMenuModel menuModelMock;
    private MenuController controller;

    @Before
    public void initController() {
        mainControllerMock = Mockito.mock(MainController.class);

        Option optMock = Mockito.mock(Option.class);
        Mockito.doAnswer(invocation -> {
            return null;
        }).when(optMock).execute();

        menuModelMock = Mockito.mock(MainMenuModel.class);
        Mockito.when(menuModelMock.getAction()).thenReturn(optMock);

        menuViewMock = Mockito.mock(GeneralView.class);
        controller = new MenuController(mainControllerMock, menuModelMock, menuViewMock);
    }

    @Test
    public void testHandler() {
        Assert.assertTrue(controller.processCommand(KeyHandler.KEY.UP));
        Mockito.verify(menuModelMock, Mockito.times(1)).previousAction();

        Assert.assertFalse(controller.processCommand(KeyHandler.KEY.RIGHT));
        Mockito.verify(menuModelMock, Mockito.times(1)).getAction();

        Assert.assertTrue(controller.processCommand(KeyHandler.KEY.DOWN));
        Mockito.verify(menuModelMock, Mockito.times(1)).nextAction();

        Assert.assertFalse(controller.processCommand(KeyHandler.KEY.CLOSE));
        Mockito.verify(mainControllerMock, Mockito.times(1)).exit();

        Assert.assertTrue(controller.processCommand(KeyHandler.KEY.LEFT));
    }

    @Test
    public void menuRun() throws IOException {
        Mockito.when(menuViewMock.handler()).thenReturn(KeyHandler.KEY.CLOSE);
        controller.run();

        Mockito.verify(menuViewMock, Mockito.times(1)).draw();
        Mockito.verify(menuViewMock, Mockito.times(1)).handler();
    }
}
