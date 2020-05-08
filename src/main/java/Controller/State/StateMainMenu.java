package Controller.State;

import Controller.CommandOption.CommandOptionExit;
import Controller.CommandOption.CommandOptionNewGame;
import Controller.MainController;
import Controller.Menu.MenuController;
import Model.Menu.MenuModel;
import Model.Option.OptionModel;
import Model.Position;
import View.Menu.MenuView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateMainMenu extends State {
    public StateMainMenu(MainController mainController) {
        super(mainController);
    }

    @Override
    public void run() throws IOException {
        List<OptionModel> op = new ArrayList<>();
        op.add(new OptionModel("Start", new Position(2, 14), new CommandOptionNewGame(mainController)));
        op.add(new OptionModel("Instructions", new Position(2, 15), new CommandOptionNewGame(mainController)));
        op.add(new OptionModel("Exit", new Position(2, 16), new CommandOptionExit(mainController)));

        MenuModel menuModel = new MenuModel(op);
        MenuView menuView = new MenuView(mainController.getGui());

        MenuController controller = new MenuController(menuModel, menuView);

        controller.run();
    }
}
