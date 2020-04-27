package View.Element;

import Model.Elements.ElementModel;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ElementView {
    public void draw(ElementModel model, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(model.getColor()));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(model.getPosition().getX(), model.getPosition().getY()), model.getImage());
    }
}
