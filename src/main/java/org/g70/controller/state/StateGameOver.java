package org.g70.controller.state;

import org.g70.controller.menu.option.OptionMainMenu;
import org.g70.controller.menu.option.OptionNewGame;
import org.g70.controller.MainController;
import org.g70.controller.menu.MenuController;
import org.g70.model.menu.GameOverModel;
import org.g70.model.drawable.menudrawable.MenuOption;
import org.g70.model.Position;
import org.g70.view.game.GeneralView;
import org.g70.view.game.MenuView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateGameOver extends State {
    GameOverModel mainMenuModel;
    int globalScore;

    public StateGameOver(MainController mainController, int globalScore) {
        super(mainController);

        initGameOver();

        this.globalScore = globalScore;
    }

    private void initGameOver() {
        List<MenuOption> op = new ArrayList<>();
        op.add(new MenuOption("Restart", new Position(2, 15), new OptionNewGame(mainController)));
        op.add(new MenuOption("Main Menu", new Position(2, 16), new OptionMainMenu(mainController)));

        mainMenuModel = new GameOverModel(op, globalScore);
        view = new MenuView(mainController.getGui(), mainMenuModel);
    }


    @Override
    public void run() throws IOException {
        MenuController controller = new MenuController(mainController, mainMenuModel, view);

        controller.run();
    }
}
