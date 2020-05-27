package org.g70;

import org.g70.controller.MainController;
import org.g70.view.ScreenView;

import java.awt.*;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException, InterruptedException, FontFormatException {
        ScreenView gui = new ScreenView(30, 20);

        MainController controller = new MainController(gui);
        controller.run();

        gui.close();
    }
}