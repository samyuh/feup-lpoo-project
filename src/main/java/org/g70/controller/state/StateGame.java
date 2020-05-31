package org.g70.controller.state;

import org.g70.controller.level.LevelController;
import org.g70.controller.MainController;
import org.g70.model.level.LevelHeaderModel;
import org.g70.model.level.LevelModel;
import org.g70.view.game.GeneralView;
import org.g70.view.game.LevelView;

import java.io.IOException;

public class StateGame extends State {
    private LevelModel levelModel;
    private LevelHeaderModel headerModel;

    public StateGame(MainController mainController) {
        super(mainController);

        initState();
    }

    @Override
    protected void initState() {
        levelModel = new LevelModel();
        headerModel = new LevelHeaderModel(1);
        view = new LevelView(mainController.getGui(), levelModel, headerModel);
    }

    @Override
    public void run() throws IOException {
        LevelController controller = new LevelController(levelModel, headerModel, view);

        controller. run();

        mainController.setState(new StateGameOver(mainController, headerModel.getGlobalScore().getScore()));
    }
}
