package org.g70.controller.menu.option;

import org.g70.controller.MainController;

public class OptionExit extends Option {
    public OptionExit(MainController mainController) {
        super(mainController);
    }

    @Override
    public void execute() {
        mainController.exit();
    }
}
