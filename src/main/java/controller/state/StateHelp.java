package controller.state;

import controller.MainController;
import controller.menu.MenuController;
import controller.menu.option.OptionExit;
import controller.menu.option.OptionHelp;
import controller.menu.option.OptionMainMenu;
import controller.menu.option.OptionNewGame;
import model.Position;
import model.drawable.menu.MenuOption;
import model.menu.HelpModel;
import view.menu.MenuView;

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
