package view.menu;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import model.drawable.Drawable;
import model.menu.HelpModel;
import view.drawable.DrawableView;
import view.ScreenView;
import view.GeneralView;

import java.io.IOException;
import java.util.List;

public class HelpView extends GeneralView {
    HelpModel model;

    public HelpView(ScreenView gui, HelpModel model) {
        super(gui.getScreen());
        this.model = model;
    }


    public void draw() throws IOException {
        screen.clear();

        graphics.setBackgroundColor(TextColor.Factory.fromString("#000077"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(30, 24), ' ');

        graphics.putString(2, 1, "Instructions", SGR.BOLD);

        DrawableView view = new DrawableView();
        List<Drawable> options = model.getElements();

        for(Drawable option : options)
            view.draw(option, graphics);

        screen.refresh();
    }
}
