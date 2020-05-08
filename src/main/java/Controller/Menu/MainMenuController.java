package Controller.Menu;

import Model.Menu.MainMenuModel;
import View.KeyHandler;
import View.Menu.MainMenuView;

import java.io.IOException;

public class MainMenuController {
    private MainMenuModel menuModel;
    private MainMenuView menuView;

    public MainMenuController(MainMenuModel menuModel, MainMenuView menuView) {
        this.menuModel = menuModel;
        this.menuView = menuView;
    }

    public boolean run() throws IOException {
        while(true) {
            menuView.draw(menuModel);
            if (processCommand(menuView.handler())) {
                return menuModel.getAction().execute();
            }
        }
    }

    public boolean processCommand(KeyHandler.DIRECTION command) {
        switch (command) {
            case UP:
                menuModel.previousAction();
                return false;
            case DOWN:
                menuModel.nextAction();
                return false;
            case RIGHT:
                return true;
            case CLOSE:
                return true;
        }
        return false;
    }
}
