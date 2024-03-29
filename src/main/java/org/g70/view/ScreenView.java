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
    private Screen screen;

    public ScreenView(int width, int height) throws IOException, FontFormatException {

        File file = new File(this.getClass().getResource("/font/square.ttf").getFile());

            // Custom Font
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(28f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            AWTTerminalFontConfiguration config = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, customFont);

            Terminal terminal = new DefaultTerminalFactory()
                    .setInitialTerminalSize(new TerminalSize(width, height))
                    .setTerminalEmulatorFontConfiguration(config).createTerminal();

            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
    }

    public Screen getScreen() {
        return screen;
    }

    public void close() throws IOException {
        screen.close();
    }
}
