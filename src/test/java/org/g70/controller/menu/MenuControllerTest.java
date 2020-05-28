package org.g70.controller.menu;

import org.g70.controller.MainController;
import org.g70.controller.menu.option.Option;
import org.g70.model.drawable.menudrawable.MenuOption;
import org.g70.model.menu.MainMenuModel;
import org.g70.view.game.GeneralView;
import org.g70.view.handler.KeyHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuControllerTest {
    MainController mainControllerMock;
    GeneralView menuViewMock;
    MainMenuModel menuModelMock;

    MenuController controller;

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
    public void testHandler() throws IOException {
        Mockito.when(menuViewMock.handler()).thenReturn(KeyHandler.KEY.CLOSE);
        controller.run();

        Mockito.verify(menuViewMock, Mockito.times(1)).draw();
        Mockito.verify(menuViewMock, Mockito.times(1)).handler();
        Mockito.verify(mainControllerMock, Mockito.times(1)).exit();


        controller.processCommand(KeyHandler.KEY.UP);
        Mockito.verify(menuModelMock, Mockito.times(1)).previousAction();

        controller.processCommand(KeyHandler.KEY.RIGHT);
        Mockito.verify(menuModelMock, Mockito.times(1)).getAction();

        controller.processCommand(KeyHandler.KEY.DOWN);
        Mockito.verify(menuModelMock, Mockito.times(1)).nextAction();
    }
}
