package org.g70.controller.menu.option;

import org.g70.controller.MainController;
import org.g70.controller.state.StateMainMenu;

public class OptionMainMenu extends Option {
    public OptionMainMenu(MainController mainController) {
        super(mainController);
    }

    @Override
    public void execute() {
        mainController.setState(new StateMainMenu(mainController));
    }
}