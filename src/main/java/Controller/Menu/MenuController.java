package Controller.Menu;

import Model.Menu.MenuModel;
import View.KeyHandler;
import View.Menu.MenuView;

import java.io.IOException;

public class MenuController {
    private MenuModel menuModel;
    private MenuView menuView;

    public MenuController(MenuModel menuModel, MenuView menuView) {
        this.menuModel = menuModel;
        this.menuView = menuView;
    }

    public void run() throws IOException {
        while(true) {
            menuView.draw(menuModel);
            if (processCommand(menuView.handler())) {
                menuModel.getAction().execute();
                return;
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
