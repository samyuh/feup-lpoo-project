package View.Game;

import Model.Elements.*;
import Model.Game.Arena;
import View.Element.*;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class ArenaView {
    public void draw(Arena model, TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(model.getWidth(), model.getHeight()), ' ');

        ElementView view = new ElementView();


        List<ElementModel> elements;
        elements = model.getAll();

        for(ElementModel element : elements)
            view.draw(element,graphics);

    }
}
