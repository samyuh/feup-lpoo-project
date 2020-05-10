package view.level;

import model.drawable.Drawable;
import model.level.LevelModel;
import view.DrawableView;
import view.KeyHandler;
import view.ScreenView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.List;

public class LevelView {
    Screen screen;

    public LevelView(ScreenView gui) {
        this.screen = gui.getScreen();
    }

    public KeyHandler.DIRECTION handler() throws IOException {
        KeyHandler k = new KeyHandler();
        return k.processKey(screen);
    }

    public void draw(LevelModel levelModel) throws IOException {
        this.screen.clear();
        drawLevel(levelModel, screen.newTextGraphics());
        this.screen.refresh();
    }

    public void drawLevel(LevelModel model, TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#8dc5f0"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(30, 24), ' ');

        DrawableView view = new DrawableView();
        List<Drawable> drawables;

        drawables = model.getAll();

        for(Drawable element : drawables)
            view.draw(element, graphics);
    }
}
