package org.g70.controller.state;

import org.g70.controller.MainController;
import org.g70.view.game.GeneralView;

import java.io.IOException;

public abstract class State {
    protected MainController mainController;
    protected GeneralView view;

    public State(MainController mainController) {
        this.mainController = mainController;
    }

    public GeneralView getView() {
        return view;
    }

    public void setView(GeneralView view) {
        this.view = view;
    }

    public abstract void run() throws IOException, InterruptedException;
}