package org.g70.controller.menu.option;

import org.g70.controller.MainController;

public abstract class Option {
    protected MainController mainController;

    public Option(MainController mainController) {
        this.mainController = mainController;
    }

    public abstract void execute();
}
