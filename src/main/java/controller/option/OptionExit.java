package controller.option;

import controller.MainController;

public class OptionExit extends Option {
    public OptionExit(MainController mainController) {
        super(mainController);
    }

    @Override
    public void execute() {
        mainController.exit();
    }
}
