import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;

public class Game {

    private Screen screen;
    private Arena arena;


    public Game() {
        try {
            Font font = new Font(Font.MONOSPACED, Font.PLAIN, 11);
            AWTTerminalFontConfiguration config = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);

            Terminal terminal = new DefaultTerminalFactory().
                    setInitialTerminalSize(new TerminalSize(150, 50)).setTerminalEmulatorFontConfiguration(config).createTerminal();

            this.screen = new TerminalScreen(terminal);
            this.arena = new Arena(150,50);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

            draw();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {

        KeyStroke key;

        do {
            key = screen.readInput();
            if(!processKey(key)) break;
            draw();
        }while (true);
        screen.close();
    }


    private boolean processKey(KeyStroke key) {

       return arena.processKey(key);

    }


}
