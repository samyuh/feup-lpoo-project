package Controller.Option;

import Controller.MainController;
import Controller.State.StateGame;

public class OptionNewGame extends Option {
    public OptionNewGame(MainController mainController) {
        super(mainController);
    }

    @Override
    public void execute() {
        mainController.setState(new StateGame(mainController));
    }
}
