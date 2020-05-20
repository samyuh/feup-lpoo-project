package controller.state;

import controller.level.LevelController;
import controller.MainController;
import model.level.LevelHeaderModel;
import model.level.LevelModel;
import view.level.LevelView;

import java.io.IOException;

public class StateGame extends State {
    public StateGame(MainController mainController) {
        super(mainController);
    }

    @Override
    public void run() throws IOException {
        LevelModel levelModel = new LevelModel();
        LevelHeaderModel headerModel = new LevelHeaderModel(1);
        LevelView levelView = new LevelView(mainController.getGui(), levelModel, headerModel);

        LevelController controller = new LevelController(mainController, levelModel, headerModel, levelView);

        controller.run();
    }
}
