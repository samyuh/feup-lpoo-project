package Controller.Menu;

import Model.Menu.MainMenuModel;
import View.Level.LevelView;
import View.Menu.GameOverView;
import View.Menu.MainMenuView;

import java.io.IOException;

public class GameOverController {
    private MainMenuModel menuModel;
    private GameOverView menuView;

    public GameOverController(MainMenuModel menuModel, GameOverView menuView) {
        this.menuModel = menuModel;
        this.menuView = menuView;
    }

    public boolean run() throws IOException {
        while(true) {
            menuView.draw(menuModel);
            return processCommand(menuView.processKey());
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
                return false;
            case CLOSE:
                return false;
        }
        return false;
    }
}
