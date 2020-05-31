package org.g70.controller.state;

import org.g70.controller.MainController;
import org.g70.controller.menu.MenuController;
import org.g70.controller.menu.option.OptionMainMenu;
import org.g70.controller.menu.option.OptionNewGame;
import org.g70.model.Position;
import org.g70.model.drawable.menudrawable.MenuOption;
import org.g70.model.menu.HelpModel;
import org.g70.view.game.GeneralView;
import org.g70.view.game.MenuView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateHelp extends State {
    private HelpModel helpModel;

    public StateHelp(MainController mainController) {
        super(mainController);

        initState();
    }

    @Override
    protected void initState() {
        List<MenuOption> op = new ArrayList<>();
        op.add(new MenuOption("Start", new Position(16, 16), new OptionNewGame(mainController)));
        op.add(new MenuOption("Main Menu", new Position(2, 16), new OptionMainMenu(mainController)));

        helpModel = new HelpModel(op);
        view = new MenuView(mainController.getGui(), helpModel);
    }

    @Override
    public void run() throws IOException {
        MenuController controller = new MenuController(mainController, helpModel, view);
        controller.run();
    }
}
