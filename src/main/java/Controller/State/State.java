package Controller.State;

import Controller.MainController;
import View.ScreenView;

import java.io.IOException;

public abstract class State {
    protected MainController mainController;
    protected ScreenView gui;

    public State(MainController mainController, ScreenView gui) {
        this.mainController = mainController;
        this.gui = gui;
    }

    public abstract void run() throws IOException, InterruptedException;
}