package Controller.CommandOption;

import Controller.MainController;

public class CommandOptionExit extends CommandOption {
    public CommandOptionExit(MainController mainController) {
        super(mainController);
    }

    @Override
    public void execute() {
        mainController.exit();
    }
}
