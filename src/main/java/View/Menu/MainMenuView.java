package View.Menu;

import Model.Menu.MainMenuModel;
import View.Level.LevelView;
import View.ScreenView;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class MainMenuView {
    Screen screen;

    public MainMenuView(ScreenView gui) {
        this.screen = gui.getScreen();
    }

    public void draw(MainMenuModel model) throws IOException {

        screen.clear();
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000077"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(30, 24), ' ');

        graphics.putString(2, 1, "FrostBite Penguin Madness", SGR.BOLD);

        int n = model.getAction();

        if(n == 0) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#120A8F"));
            graphics.putString(2, 14, "Start Game", SGR.BOLD);
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000077"));
            graphics.putString(2, 15, "Instructions", SGR.BOLD);
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000077"));
            graphics.putString(2, 16, "Exit Game", SGR.BOLD);
        }
        if(n == 1) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000077"));
            graphics.putString(2, 14, "Start Game", SGR.BOLD);
            graphics.setBackgroundColor(TextColor.Factory.fromString("#120A8F"));
            graphics.putString(2, 15, "Instructions", SGR.BOLD);
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000077"));
            graphics.putString(2, 16, "Exit Game", SGR.BOLD);
        }
        if(n == 2) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000077"));
            graphics.putString(2, 14, "Start Game", SGR.BOLD);
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000077"));
            graphics.putString(2, 15, "Instructions", SGR.BOLD);
            graphics.setBackgroundColor(TextColor.Factory.fromString("#120A8F"));
            graphics.putString(2, 16, "Exit Game", SGR.BOLD);
        }

        screen.refresh();
    }

    public LevelView.DIRECTION processKey() throws IOException {
        while (true) {
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.ArrowUp) return LevelView.DIRECTION.UP;
            if (key.getKeyType() == KeyType.ArrowRight) return LevelView.DIRECTION.RIGHT;
            if (key.getKeyType() == KeyType.ArrowDown) return LevelView.DIRECTION.DOWN;
            if (key.getKeyType() == KeyType.ArrowLeft) return LevelView.DIRECTION.LEFT;
            if (key.getKeyType() == KeyType.EOF) return LevelView.DIRECTION.CLOSE;
        }
    }
}
