package Controller.State;

import Controller.MainController;

public class StateGameOver extends State {
    public StateGameOver(MainController mainController) {
        super(mainController);
    }

    @Override
    public void run() {
        mainController.exit();
    }
}
