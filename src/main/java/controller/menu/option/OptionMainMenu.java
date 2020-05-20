package controller.menu.option;

import controller.MainController;
import controller.state.StateMainMenu;

public class OptionMainMenu extends Option {
    public OptionMainMenu(MainController mainController) {
        super(mainController);
    }

    @Override
    public void execute() {
        mainController.setState(new StateMainMenu(mainController));
    }
}