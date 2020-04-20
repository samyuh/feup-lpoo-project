package View.Element;

import Model.Elements.White;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class WhiteView extends ElementView {
    public void draw(White model, TextGraphics graphics) {
        super.draw(model, "#FFFFFF", "B", graphics);
    }
}
