package View.Element;

import Model.Elements.Key;
import Model.Elements.Wall;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class KeyView extends ElementView {
    public void draw(Key model, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffbb33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(model.getPosition().getX(), model.getPosition().getY()), "K");
    }
}
