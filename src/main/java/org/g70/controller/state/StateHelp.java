package org.g70.controller.state;

import org.g70.controller.MainController;
import org.g70.controller.menu.MenuController;
import org.g70.controller.menu.option.OptionMainMenu;
import org.g70.controller.menu.option.OptionNewGame;
import org.g70.model.Position;
import org.g70.model.drawable.menu.MenuOption;
import org.g70.model.menu.HelpModel;
import org.g70.view.game.MenuView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateHelp extends State {

    public StateHelp(MainController mainController) {
        super(mainController);
    }

    @Override
    public void run() throws IOException {
        List<MenuOption> op = new ArrayList<>();
        op.add(new MenuOption("Start", new Position(16, 16), new OptionNewGame(mainController)));
        op.add(new MenuOption("Main Menu", new Position(2, 16), new OptionMainMenu(mainController)));

        HelpModel helpModel = new HelpModel(op);
        MenuView helpView = new MenuView(mainController.getGui(), helpModel);
        MenuController controller = new MenuController(mainController, helpModel, helpView);

        controller.run();
    }
}
