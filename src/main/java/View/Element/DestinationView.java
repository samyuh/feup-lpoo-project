package View.Element;

import Model.Elements.Destination;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DestinationView extends ElementView {
    public void draw(Destination model, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#e64c4c"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(model.getPosition().getX(), model.getPosition().getY()), "D");
    }
}
