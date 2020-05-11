package controller.menu.option;

import controller.MainController;
import controller.state.StateGame;

public class OptionNewGame extends Option {
    public OptionNewGame(MainController mainController) {
        super(mainController);
    }

    @Override
    public void execute() {
        mainController.setState(new StateGame(mainController));
    }
}
