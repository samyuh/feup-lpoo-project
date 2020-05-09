package Controller.Option;

import Controller.MainController;

public class OptionExit extends Option {
    public OptionExit(MainController mainController) {
        super(mainController);
    }

    @Override
    public void execute() {
        mainController.exit();
    }
}
