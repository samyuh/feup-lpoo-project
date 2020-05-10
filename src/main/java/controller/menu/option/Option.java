package controller.menu.option;

import controller.MainController;

public abstract class Option {
    MainController mainController;

    public Option(MainController mainController) {
        this.mainController = mainController;
    }

    public abstract void execute();
}
