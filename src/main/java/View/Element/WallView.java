package View.Element;

import Model.Elements.Wall;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class WallView extends ElementView {
    public void draw(Wall model, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#8abde8"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(model.getPosition().getX(), model.getPosition().getY()), "\u2588");
    }
}
