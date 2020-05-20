package org.g70.controller.state;

import org.g70.controller.menu.option.OptionMainMenu;
import org.g70.controller.menu.option.OptionNewGame;
import org.g70.controller.MainController;
import org.g70.controller.menu.MenuController;
import org.g70.model.menu.GameOverModel;
import org.g70.model.drawable.menu.MenuOption;
import org.g70.model.Position;
import org.g70.view.menu.MenuView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateGameOver extends State {
    int globalScore;

    public StateGameOver(MainController mainController, int globalScore) {
        super(mainController);
        this.globalScore = globalScore;
    }

    @Override
    public void run() throws IOException {
        List<MenuOption> op = new ArrayList<>();
        op.add(new MenuOption("Restart", new Position(2, 15), new OptionNewGame(mainController)));
        op.add(new MenuOption("Main Menu", new Position(2, 16), new OptionMainMenu(mainController)));

        GameOverModel MainMenuModel = new GameOverModel(op, globalScore);
        MenuView menuView = new MenuView(mainController.getGui(), MainMenuModel);

        MenuController controller = new MenuController(mainController, MainMenuModel, menuView);

        controller.run();
    }
}
