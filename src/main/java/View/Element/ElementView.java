package View.Element;

import Model.Drawable.Drawable;
import Model.Elements.ElementModel;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ElementView {
    public void draw(Drawable drawable, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(drawable.getColor()));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(drawable.getPosition().getX(), drawable.getPosition().getY()), drawable.getImage());
    }
}
