package Controller.State;

import Controller.Option.OptionExit;
import Controller.Option.OptionNewGame;
import Controller.MainController;
import Controller.Menu.MenuController;
import Model.Menu.MenuModel;
import Model.Option.OptionModel;
import Model.Position;
import View.Menu.MenuView;

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
