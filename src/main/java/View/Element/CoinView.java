package View.Element;

import Model.Elements.Coin;
import Model.Elements.ElementModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class CoinView extends ElementView {
    public void draw(Coin model, TextGraphics graphics) {
        super.draw(model, "#FFFF33", "C", graphics);
    }
}
