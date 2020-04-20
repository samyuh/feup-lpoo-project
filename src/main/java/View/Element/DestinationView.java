package View.Element;

import Model.Elements.Destination;
import Model.Elements.ElementModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DestinationView extends ElementView {
    public void view(ElementModel model, TextGraphics graphics) {
        super.draw(model, "#e64c4c", "D", graphics);
    }
}
