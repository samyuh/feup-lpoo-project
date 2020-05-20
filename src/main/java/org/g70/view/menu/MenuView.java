package org.g70.view.menu;

import org.g70.model.drawable.Drawable;
import org.g70.model.menu.MenuModel;
import org.g70.model.drawable.menu.MenuOption;
import org.g70.view.drawable.DrawableView;
import org.g70.view.GeneralView;
import org.g70.view.ScreenView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.util.List;

public class MenuView extends GeneralView {
    MenuModel model;

    public MenuView(ScreenView gui, MenuModel model) {
        super(gui.getScreen());
        this.model = model;
    }

    public void draw() throws IOException {
        screen.clear();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000077"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(30, 24), ' ');

        DrawableView view = new DrawableView();

        List<Drawable> drawables = model.getTextBoxes();
        List<MenuOption> options = model.getOption();

        drawables.addAll(options);

        for(Drawable drawable : drawables)
            view.draw(drawable, graphics);

        screen.refresh();
    }
}
