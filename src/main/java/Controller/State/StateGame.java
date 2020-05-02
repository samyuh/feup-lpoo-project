package Controller.State;

import Controller.Level.LevelController;
import Controller.MainController;
import Model.Level.LevelModel;
import View.Level.LevelView;
import View.ScreenView;

import java.io.IOException;

public class StateGame extends State {
    private LevelView levelView;
    private LevelModel levelModel;

    public StateGame(MainController mainController, ScreenView gui) {
        super(mainController);
        this.levelView = new LevelView(gui);
        this.levelModel = new LevelModel();
    }

    public void run() throws IOException {
        LevelController controller = new LevelController(levelModel, levelView);

        if(!controller.run())
            mainController.setState(new StateGameOver(mainController));
    }
}
