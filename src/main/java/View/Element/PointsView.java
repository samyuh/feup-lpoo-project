package View.Element;

import Model.Elements.Destination;
import Model.Elements.ElementModel;
import Model.Elements.Points;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PointsView extends ElementView {
    public void draw(Points model, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(model.getPosition().getX(), model.getPosition().getY()), Integer.toString(model.getNumber()));
    }
}
