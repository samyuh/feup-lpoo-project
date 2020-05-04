package Controller.State;

import Controller.MainController;
import Controller.Menu.GameOverController;
import Controller.Menu.MainMenuController;
import Model.Menu.MainMenuModel;
import View.Menu.GameOverView;
import View.Menu.MainMenuView;
import View.ScreenView;

import java.io.IOException;

public class StateGameOver extends State {

    public StateGameOver(MainController mainController, ScreenView gui) {
        super(mainController, gui);
    }

    @Override
    public void run() throws IOException {
        MainMenuModel menuModel = new MainMenuModel();
        GameOverView menuView = new GameOverView(gui);
        GameOverController controller = new GameOverController(menuModel, menuView);
        controller.run();
        mainController.exit();
    }
}
