package Controller.State;

import Controller.Level.LevelController;
import Controller.MainController;
import Model.Level.LevelModel;
import View.Level.LevelView;
import View.ScreenView;

import java.io.IOException;

public class StateGame extends State {
    public StateGame(MainController mainController) {
        super(mainController);
    }

    public void run() throws IOException {
        LevelView levelView = new LevelView(mainController.getGui());
        LevelModel levelModel = new LevelModel();

        LevelController controller = new LevelController(levelModel, levelView);

        if(controller.run())
            mainController.setState(new StateMainMenu(mainController)); // You finished the game!
        else
            mainController.setState(new StateGameOver(mainController));

    }
}
