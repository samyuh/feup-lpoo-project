package org.g70.view.game;

import org.g70.model.drawable.Drawable;
import org.g70.model.level.LevelHeaderModel;
import org.g70.model.level.LevelModel;
import org.g70.view.drawable.DrawableView;
import org.g70.view.ScreenView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LevelView extends GeneralView {
    private LevelModel levelModel;
    private LevelHeaderModel headerModel;

    public LevelView(ScreenView gui, LevelModel levelModel, LevelHeaderModel headerModel) {
        super(gui.getScreen());

        this.levelModel = levelModel;
        this.headerModel = headerModel;
    }

    @Override
    public void draw() throws IOException {
        screen.clear();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#8dc5f0"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(30, 24), ' ');

        DrawableView view = new DrawableView();
        List<Drawable> drawables = new ArrayList<>();

        drawables.addAll(levelModel.getAll());
        drawables.addAll(headerModel.getAll());

        for(Drawable element : drawables)
            view.draw(element, graphics);

        screen.refresh();
    }
}
