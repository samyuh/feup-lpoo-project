package org.g70.controller.state;

import org.g70.controller.MainController;

import java.io.IOException;

public abstract class State {
    protected MainController mainController;

    public State(MainController mainController) {
        this.mainController = mainController;
    }

    public abstract void run() throws IOException, InterruptedException;
}