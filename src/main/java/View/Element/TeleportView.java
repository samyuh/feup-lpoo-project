package View.Element;

import Model.Elements.Teleport;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class TeleportView extends ElementView {

    public void draw(Teleport model, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#7edd94"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(model.getPosition().getX(), model.getPosition().getY()), "T");
    }
}
