package view.menu;

import model.drawable.Drawable;
import model.menu.MenuModel;
import model.drawable.menu.MenuOption;
import view.DrawableView;
import view.handler.KeyHandler;
import view.ScreenView;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.List;

public class MenuView {
    Screen screen;

    public MenuView(ScreenView gui) {
        this.screen = gui.getScreen();
    }

    public KeyHandler.DIRECTION handler() throws IOException {
        KeyHandler k = new KeyHandler();
        return k.processKey(screen);
    }

    public void draw(MenuModel model) throws IOException {
        screen.clear();
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000077"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(30, 24), ' ');

        graphics.putString(2, 1, "FrostBite Penguin Madness", SGR.BOLD);

        DrawableView view = new DrawableView();
        List<MenuOption> options = model.getOption();

        for(Drawable option : options)
            view.draw(option, graphics);

        screen.refresh();
    }
}