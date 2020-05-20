package org.g70.controller.menu.option;

import org.g70.controller.MainController;
import org.g70.controller.state.StateHelp;

public class OptionHelp extends Option {
    public OptionHelp(MainController mainController) {
        super(mainController);
    }

    @Override
    public void execute() {
        mainController.setState(new StateHelp(mainController));
    }
}