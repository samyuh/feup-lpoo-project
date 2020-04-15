package View.Element;

import Model.Elements.Lock;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class LockView extends ElementView {
    public void draw(Lock model, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#803808"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(model.getPosition().getX(), model.getPosition().getY()), "L");
    }
}
