package View.Element;

import Model.Elements.ElementModel;
import Model.Elements.Wall;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class WallView extends ElementView {
    public void view(ElementModel model, TextGraphics graphics) {
        super.draw(model, "#8abde8", "\u2588", graphics);
    }
}
