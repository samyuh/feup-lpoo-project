package org.g70.controller;

import org.g70.controller.state.*;
import org.g70.view.ScreenView;
import org.g70.view.game.GeneralView;

import java.io.IOException;

public class MainController {
    private ScreenView gui;
    private State state;
    private boolean exit;

    public MainController(ScreenView gui) {
        this.gui = gui;
        this.exit = false;

        setState(new StateMainMenu(this));
    }

    public ScreenView getGui() {
        return gui;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public boolean getExit() {
        return exit;
    }

    public void exit() {
        this.exit = true;
    }

    public void run() throws IOException, InterruptedException {
        while(!exit) {
            this.state.run();
        }
    }
}
