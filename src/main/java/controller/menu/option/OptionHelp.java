package controller.menu.option;

import controller.MainController;
import controller.state.StateHelp;

public class OptionHelp extends Option {
    public OptionHelp(MainController mainController) {
        super(mainController);
    }

    @Override
    public void execute() {
        mainController.setState(new StateHelp(mainController));
    }
}