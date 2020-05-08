package Controller.CommandOption;

import Controller.MainController;
import Controller.State.StateGame;

public class CommandOptionNewGame extends CommandOption {
    public CommandOptionNewGame(MainController mainController) {
        super(mainController);
    }

    @Override
    public void execute() {
        mainController.setState(new StateGame(mainController));
    }
}
