package controller.state;

import controller.level.LevelController;
import controller.MainController;
import model.level.LevelModel;
import view.level.LevelView;

import java.io.IOException;

public class StateGame extends State {
    public StateGame(MainController mainController) {
        super(mainController);
    }

    public void run() throws IOException {
        LevelView levelView = new LevelView(mainController.getGui());
        LevelModel levelModel = new LevelModel();

        LevelController controller = new LevelController(levelModel, levelView);

        controller.run();

        mainController.setState(new StateGameOver(mainController));
    }
}
