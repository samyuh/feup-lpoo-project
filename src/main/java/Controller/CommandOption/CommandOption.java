package Controller.CommandOption;

import Controller.MainController;

public abstract class CommandOption {
    MainController mainController;

    public CommandOption(MainController mainController) {
        this.mainController = mainController;
    }

    public abstract void execute();
}
