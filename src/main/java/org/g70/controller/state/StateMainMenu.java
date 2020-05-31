package org.g70.controller.state;

import org.g70.controller.menu.option.OptionExit;
import org.g70.controller.menu.option.OptionHelp;
import org.g70.controller.menu.option.OptionNewGame;
import org.g70.controller.MainController;
import org.g70.controller.menu.MenuController;
import org.g70.model.menu.MainMenuModel;
import org.g70.model.drawable.menudrawable.MenuOption;
import org.g70.model.Position;
import org.g70.view.game.MenuView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateMainMenu extends State {
    private MainMenuModel mainMenuModel;

    public StateMainMenu(MainController mainController) {
        super(mainController);

        initState();
    }

    @Override
    protected void initState() {
        List<MenuOption> options = new ArrayList<>();

        options.add(new MenuOption("Start", new Position(2, 14), new OptionNewGame(mainController)));
        options.add(new MenuOption("Instructions", new Position(2, 15), new OptionHelp(mainController)));
        options.add(new MenuOption("Exit", new Position(2, 16), new OptionExit(mainController)));

        mainMenuModel = new MainMenuModel(options);
        view = new MenuView(mainController.getGui(), mainMenuModel);
    }

    @Override
    public void run() throws IOException {
        MenuController controller = new MenuController(mainController, mainMenuModel, view);
        controller.run();
    }
}
