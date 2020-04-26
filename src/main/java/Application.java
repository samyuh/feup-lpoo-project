

import Controller.MainController;
import View.ScreenView;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        ScreenView gui = new ScreenView(30, 20);
        MainController controller = new MainController(gui);
        controller.run();

        gui.close();
    }
}