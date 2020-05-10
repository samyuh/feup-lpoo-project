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

public class StateMainMenu extends State {
    public StateMainMenu(MainController mainController) {
        super(mainController);
    }

    @Override
    public void run() throws IOException {
        List<OptionModel> op = new ArrayList<>();
        op.add(new OptionModel("Start", new Position(2, 14), new OptionNewGame(mainController)));
        op.add(new OptionModel("Instructions", new Position(2, 15), new OptionNewGame(mainController)));
        op.add(new OptionModel("Exit", new Position(2, 16), new OptionExit(mainController)));

        MenuModel menuModel = new MenuModel(op);
        MenuView menuView = new MenuView(mainController.getGui());

        MenuController controller = new MenuController(mainController, menuModel, menuView);

        controller.run();
    }
}
