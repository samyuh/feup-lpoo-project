package org.g70.view.game;

import org.g70.model.drawable.Drawable;
import org.g70.model.menu.MenuFactory;
import org.g70.model.drawable.menudrawable.MenuOption;
import org.g70.view.drawable.DrawableView;
import org.g70.view.ScreenView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.util.List;

public class MenuView extends GeneralView {
    private MenuFactory model;

    public MenuView(ScreenView gui, MenuFactory model) {
        super(gui.getScreen());

        this.model = model;
    }

    @Override
    public void draw() throws IOException {
        screen.clear();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000077"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(30, 24), ' ');

        DrawableView view = new DrawableView();
        List<Drawable> drawables = model.getTextBoxes();
        List<MenuOption> options = model.getOptions();

        drawables.addAll(options);

        for(Drawable element : drawables)
            view.draw(element, graphics);

        screen.refresh();
    }
}
