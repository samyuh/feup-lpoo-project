package controller.state;

import controller.menu.option.OptionExit;
import controller.menu.option.OptionHelp;
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

public class StateMainMenu extends State {
    public StateMainMenu(MainController mainController) {
        super(mainController);
    }

    @Override
    public void run() throws IOException {
        List<MenuOption> op = new ArrayList<>();
        op.add(new MenuOption("Start", new Position(2, 14), new OptionNewGame(mainController)));
        op.add(new MenuOption("Instructions", new Position(2, 15), new OptionHelp(mainController)));
        op.add(new MenuOption("Exit", new Position(2, 16), new OptionExit(mainController)));

        MenuModel menuModel = new MenuModel(op);
        MenuView menuView = new MenuView(mainController.getGui(), menuModel);

        MenuController controller = new MenuController(mainController, menuModel, menuView);

        controller.run();
    }
}
