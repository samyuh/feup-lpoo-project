package View.Element;

import Model.Elements.ElementModel;
import Model.Elements.Lock;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class LockView extends ElementView {
    public void view(ElementModel model, TextGraphics graphics) {
        super.draw(model, "#803808", "L", graphics);
    }
}
