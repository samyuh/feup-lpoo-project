package View.Menu;

import Model.Menu.MainMenuModel;
import Model.Option;
import View.KeyHandler;
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
import java.util.List;

public class MainMenuView {
    Screen screen;

    public MainMenuView(ScreenView gui) {
        this.screen = gui.getScreen();
    }

    public KeyHandler.DIRECTION handler() throws IOException {
        KeyHandler k = new KeyHandler();
        return k.processKey(screen);
    }

    public void draw(MainMenuModel model) throws IOException {
        screen.clear();
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000077"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(30, 24), ' ');

        graphics.putString(2, 1, "FrostBite Penguin Madness", SGR.BOLD);

        List<Option> op = model.getOption();

        graphics.setBackgroundColor(TextColor.Factory.fromString(op.get(0).getColor()));
        graphics.putString(op.get(0).getPosition().getX(), op.get(0).getPosition().getY(), op.get(0).getName(), SGR.BOLD);

        graphics.setBackgroundColor(TextColor.Factory.fromString(op.get(1).getColor()));
        graphics.putString(op.get(1).getPosition().getX(), op.get(1).getPosition().getY(), op.get(1).getName(), SGR.BOLD);

        graphics.setBackgroundColor(TextColor.Factory.fromString(op.get(2).getColor()));
        graphics.putString(op.get(2).getPosition().getX(), op.get(2).getPosition().getY(), op.get(2).getName(), SGR.BOLD);

        screen.refresh();
    }
}
