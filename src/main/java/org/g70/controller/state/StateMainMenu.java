package org.g70.controller.state;

import org.g70.controller.menu.option.OptionExit;
import org.g70.controller.menu.option.OptionHelp;
import org.g70.controller.menu.option.OptionNewGame;
import org.g70.controller.MainController;
import org.g70.controller.menu.MenuController;
import org.g70.model.menu.MainMenuModel;
import org.g70.model.drawable.menu.MenuOption;
import org.g70.model.Position;
import org.g70.view.menu.MenuView;

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

        MainMenuModel MainMenuModel = new MainMenuModel(op);
        MenuView menuView = new MenuView(mainController.getGui(), MainMenuModel);

        MenuController controller = new MenuController(mainController, MainMenuModel, menuView);

        controller.run();
    }
}
