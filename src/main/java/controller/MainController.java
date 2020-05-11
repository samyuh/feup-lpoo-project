package controller;

import controller.state.*;
import view.ScreenView;

import java.io.IOException;

public class MainController {
    private ScreenView gui;
    private State state;
    private boolean exit = false;

    public MainController(ScreenView gui) {
        this.gui = gui;
        this.state = new StateMainMenu(this);
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
