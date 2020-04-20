package View.Element;

import Model.Elements.ElementModel;
import Model.Elements.Hero;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class ElementView {
    public abstract void view(ElementModel model, TextGraphics graphics);

    public void draw(ElementModel model, String color, String image, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(model.getPosition().getX() , model.getPosition().getY()), image);
    }
}
