package controller.state;

import controller.option.OptionExit;
import controller.option.OptionNewGame;
import controller.MainController;
import controller.menu.MenuController;
import model.menu.MenuModel;
import model.option.OptionModel;
import model.Position;
import view.menu.MenuView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateGameOver extends State {

    public StateGameOver(MainController mainController) {
        super(mainController);
    }

    @Override
    public void run() throws IOException {
        List<OptionModel> op = new ArrayList<>();
        op.add(new OptionModel("Game Over", new Position(2, 15), new OptionExit(mainController)));
        op.add(new OptionModel("Restart", new Position(2, 16), new OptionNewGame(mainController)));

        MenuModel menuModel = new MenuModel(op);
        MenuView menuView = new MenuView(mainController.getGui());

        MenuController controller = new MenuController(mainController, menuModel, menuView);

        controller.run();
    }
}
