package View.Element;

import Model.Elements.ElementModel;
<<<<<<< Updated upstream
import Model.Elements.Hero;
=======
>>>>>>> Stashed changes
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

<<<<<<< Updated upstream
public abstract class ElementView {
    public abstract void view(ElementModel model, TextGraphics graphics);

    public void draw(ElementModel model, String color, String image, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(model.getPosition().getX() , model.getPosition().getY()), image);
=======
public class ElementView<T extends ElementModel> {
    public void draw(T model, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(model.getColor()));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(model.getPosition().getX(), model.getPosition().getY()), model.getImage());
>>>>>>> Stashed changes
    }
}
