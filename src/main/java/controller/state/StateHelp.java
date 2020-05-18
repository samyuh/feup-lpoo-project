package controller.state;

import controller.MainController;
import controller.menu.HelpController;
import model.menu.HelpModel;
import view.menu.HelpView;

import java.io.IOException;

public class StateHelp extends State {

    public StateHelp(MainController mainController) {
        super(mainController);
    }

    @Override
    public void run() throws IOException {
        HelpModel helpM = new HelpModel();

        HelpView helpView = new HelpView(mainController.getGui(), helpM);

        HelpController controller = new HelpController(mainController, helpM, helpView);

        controller.run();
    }
}
