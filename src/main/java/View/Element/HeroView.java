package View.Element;

import Model.Elements.Hero;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class HeroView extends ElementView {
    public void draw(Hero model, TextGraphics graphics) {
        super.draw(model, "#000000", "H", graphics);
    }
}
