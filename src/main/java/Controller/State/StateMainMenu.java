package Controller.State;

import Controller.MainController;
import Controller.Menu.MainMenuController;
import Model.Menu.MainMenuModel;
import View.Menu.MainMenuView;
import View.ScreenView;

import java.io.IOException;

public class StateMainMenu extends State {
    public StateMainMenu(MainController mainController, ScreenView gui) {
        super(mainController, gui);
    }

    @Override
    public void run() throws IOException {
        MainMenuModel menuModel = new MainMenuModel();
        MainMenuView menuView = new MainMenuView(gui);

        MainMenuController controller = new MainMenuController(menuModel, menuView);

        if(controller.run())
            mainController.setState(new StateGame(mainController, gui));
        else
            mainController.exit();
    }
}
