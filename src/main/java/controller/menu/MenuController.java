package controller.menu;

import controller.MainController;
import model.menu.MenuModel;
import view.KeyHandler;
import view.menu.MenuView;

import java.io.IOException;

public class MenuController {
    private MenuModel menuModel;
    private MenuView menuView;
    private MainController mainController;

    public MenuController(MainController mainController, MenuModel menuModel, MenuView menuView) {
        this.mainController = mainController;
        this.menuModel = menuModel;
        this.menuView = menuView;
    }
    public void run() throws IOException {
        do {
            menuView.draw(menuModel);
        } while (processCommand(menuView.handler()));
    }

    public boolean processCommand(KeyHandler.DIRECTION command) {
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

