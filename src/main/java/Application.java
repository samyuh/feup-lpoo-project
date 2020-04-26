

import Controller.MainController;
import View.ScreenView;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        ScreenView gui = new ScreenView(30, 20);
        MainController arena = new MainController(gui);

        //gui.drawGame();
        /*
        ArenaModel arena = new ArenaModel(60, 30);
        ArenaView gui = new ArenaView(60, 30);

        ArenaController controller = new ArenaController(gui, arena);
        controller.start();
         */
    }
}