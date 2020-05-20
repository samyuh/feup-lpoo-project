package controller.state;

import controller.menu.option.OptionExit;
import controller.menu.option.OptionMainMenu;
import controller.menu.option.OptionNewGame;
import controller.MainController;
import controller.menu.MenuController;
import model.menu.GameOverModel;
import model.menu.MainMenuModel;
import model.drawable.menu.MenuOption;
import model.Position;
import view.menu.MenuView;

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
