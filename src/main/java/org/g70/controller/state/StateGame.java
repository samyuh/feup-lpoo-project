package org.g70.controller.state;

import org.g70.controller.level.LevelController;
import org.g70.controller.MainController;
import org.g70.model.level.LevelHeaderModel;
import org.g70.model.level.LevelModel;
import org.g70.view.level.LevelView;

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

        LevelController controller = new LevelController(levelModel, headerModel, levelView);

        controller.run();

        mainController.setState(new StateGameOver(mainController, headerModel.getGlobalScore().getScore()));
    }
}
