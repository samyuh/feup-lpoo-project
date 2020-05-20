package org.g70.view;


import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ScreenView {
    private int width;
    private int height;

    private Screen screen;

    public ScreenView(int width, int height) {
        try {
            this.width = width;
            this.height = height;

            File file = new File(this.getClass().getResource("/font/square.ttf").getFile());

            // Costum Font
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(28f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            AWTTerminalFontConfiguration config = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, customFont);

            Terminal terminal = new DefaultTerminalFactory()
                    .setInitialTerminalSize(new TerminalSize(this.width,this.height))
                    .setTerminalEmulatorFontConfiguration(config).createTerminal();

            this.screen = new TerminalScreen(terminal);
            this.screen.setCursorPosition(null);   // we don't need a cursor
            this.screen.startScreen();             // screens must be started
            this.screen.doResizeIfNecessary();     // resize screen if necessary
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    public Screen getScreen() {
        return screen;
    }

    public void close() throws IOException {
        screen.close();
    }
}
