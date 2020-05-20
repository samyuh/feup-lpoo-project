package org.g70.controller.menu.option;

import org.g70.controller.MainController;
import org.g70.controller.state.StateGame;

public class OptionNewGame extends Option {
    public OptionNewGame(MainController mainController) {
        super(mainController);
    }

    @Override
    public void execute() {
        mainController.setState(new StateGame(mainController));
    }
}
