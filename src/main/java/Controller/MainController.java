package Controller;

import Controller.Level.LevelController;
import Model.Level.LevelModel;
import View.Level.LevelView;
import View.ScreenView;

import java.io.IOException;

public class MainController {
    public MainController(ScreenView v) throws IOException {
        LevelView level = new LevelView(v);
        LevelModel l1 = new LevelModel(1);
        LevelController lc = new LevelController(l1, level);
        lc.run();
    }
}
