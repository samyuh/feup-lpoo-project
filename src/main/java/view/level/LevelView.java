package view.level;

import model.drawable.Drawable;
import model.level.LevelModel;
import view.drawable.DrawableView;
import view.GeneralView;
import view.ScreenView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.util.List;

public class LevelView extends GeneralView {
    LevelModel levelModel;

    public LevelView(ScreenView gui, LevelModel levelModel) {
        super(gui.getScreen());
        this.levelModel = levelModel;
    }

    public void draw() throws IOException {
        this.screen.clear();

        graphics.setBackgroundColor(TextColor.Factory.fromString("#8dc5f0"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(30, 24), ' ');

        DrawableView view = new DrawableView();
        List<Drawable> drawables;

        drawables = levelModel.getAll();

        for(Drawable element : drawables)
            view.draw(element, graphics);

        this.screen.refresh();
    }
}
