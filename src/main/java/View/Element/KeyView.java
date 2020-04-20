package View.Element;

import Model.Elements.Key;
import Model.Elements.Wall;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class KeyView extends ElementView {
    public void draw(Key model, TextGraphics graphics) {
        super.draw(model, "#ffbb33", "K", graphics);
    }
}
