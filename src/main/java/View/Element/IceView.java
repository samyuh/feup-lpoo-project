package View.Element;

import Model.Elements.Ice;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class IceView extends ElementView {
    public void draw(Ice model, TextGraphics graphics) {
        super.draw(model, "#0056ac", "I", graphics);
    }
}
