package org.g70.controller.menu;

import org.g70.controller.MainController;
import org.g70.model.menu.MenuFactory;
import org.g70.view.handler.KeyHandler;
import org.g70.view.game.MenuView;

import java.io.IOException;

public class MenuController {
    private MenuFactory menuModel;
    private MenuView menuView;
    private MainController mainController;

    public MenuController(MainController mainController, MenuFactory menuModel, MenuView menuView) {
        this.mainController = mainController;
        this.menuModel = menuModel;
        this.menuView = menuView;
    }
    public void run() throws IOException {
        do {
            menuView.draw();
        } while (processCommand(menuView.handler()));
    }

    private boolean processCommand(KeyHandler.KEY command) {
        switch (command) {
            case UP:
                menuModel.previousAction();
                return true;
            case DOWN:
                menuModel.nextAction();
                return true;
            case RIGHT:
                menuModel.getAction().execute();
                return false;
            case CLOSE:
                mainController.exit();
                return false;
        }
        return true;
    }
}

