package view.menu;

import model.drawable.Drawable;
import model.menu.MenuModel;
import model.drawable.menu.MenuOption;
import view.drawable.DrawableView;
import view.GeneralView;
import view.ScreenView;
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
