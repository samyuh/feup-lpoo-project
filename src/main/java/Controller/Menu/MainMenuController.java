package Controller.Menu;

import Model.Menu.MainMenuModel;
import View.Level.LevelView;
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
            if (processCommand(menuView.processKey()))
                return true;
        }
    }

    public boolean processCommand(LevelView.DIRECTION command) {
        switch (command) {
            case UP:
                return true;
            case DOWN:
                return true;
            case LEFT:
                return true;
            case RIGHT:
                return true;
            case CLOSE:
                return false;
        }
        return false;
    }
}
