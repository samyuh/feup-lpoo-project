package controller.state;

import controller.menu.option.OptionExit;
import controller.menu.option.OptionNewGame;
import controller.MainController;
import controller.menu.MenuController;
import model.menu.MenuModel;
import model.drawable.menu.MenuOption;
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
        List<MenuOption> op = new ArrayList<>();
        op.add(new MenuOption("Game Over", new Position(2, 15), new OptionExit(mainController)));
        op.add(new MenuOption("Restart", new Position(2, 16), new OptionNewGame(mainController)));

        MenuModel menuModel = new MenuModel(op);
        MenuView menuView = new MenuView(mainController.getGui(), menuModel);

        MenuController controller = new MenuController(mainController, menuModel, menuView);

        controller.run();
    }
}
