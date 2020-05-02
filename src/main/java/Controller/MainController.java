package Controller;

import Controller.State.State;
import Controller.State.StateGame;
import View.ScreenView;

import java.io.IOException;

public class MainController {
    ScreenView gui;
    private State state;
    private boolean exit = false;

    public MainController(ScreenView gui) {
        this.gui = gui;
        this.state = new StateGame(this, gui);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void exit() {
        this.exit = true;
    }

    public void run() throws IOException {
        while(!exit) {
            this.state.run();
        }
    }


}
