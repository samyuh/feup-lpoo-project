package Controller;

import Controller.Level.LevelController;
import Model.Level.LevelModel;
import View.Level.LevelView;
import View.ScreenView;

import java.io.IOException;

public class MainController {
    private LevelView levelView;
    private LevelModel levelModel;

    public MainController(ScreenView gui) {
        this.levelView = new LevelView(gui);
        this.levelModel = new LevelModel();
    }

    public void run() throws IOException {
        LevelController controller = new LevelController(levelModel, levelView);
        controller.run();
    }
}
