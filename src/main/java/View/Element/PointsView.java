package View.Element;

import Model.Elements.Destination;
import Model.Elements.ElementModel;
import Model.Elements.Points;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PointsView extends ElementView {
    public void view(ElementModel model, TextGraphics graphics) {
        super.draw(model, "#000000", Integer.toString(((Points) model).getNumber()), graphics);
    }
}
