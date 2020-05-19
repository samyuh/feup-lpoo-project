package controller.menu;

import controller.MainController;
import controller.state.StateMainMenu;
import model.menu.HelpModel;
import view.menu.HelpView;
import view.handler.KeyHandler;

import java.io.IOException;

public class HelpController {
    private HelpModel helpModel;
    private HelpView helpView;
    private MainController mainController;

    public HelpController(MainController mainController, HelpModel helpModel, HelpView helpView) {
        this.mainController = mainController;
        this.helpModel = helpModel;
        this.helpView = helpView;
    }

    public void run() throws IOException {
        do {
            helpView.draw();
        } while (processCommand(helpView.handler()));
    }

    public boolean processCommand(KeyHandler.DIRECTION command) {
        switch (command) {
            case RIGHT:
                mainController.setState(new StateMainMenu(mainController));
                return false;
            case CLOSE:
                mainController.exit();
                return false;
        }
        return true;
    }
}
