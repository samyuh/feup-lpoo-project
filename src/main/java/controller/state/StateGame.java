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
        LevelModel levelModel = new LevelModel();
        LevelView levelView = new LevelView(mainController.getGui(), levelModel);


        LevelController controller = new LevelController(levelModel, levelView);

        if(controller.run())
            mainController.setState(new StateMainMenu(mainController)); // You finished the game!
        else
            mainController.setState(new StateGameOver(mainController));

    }
}
