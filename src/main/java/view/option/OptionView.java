package view.option;

import model.option.OptionModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class OptionView {
    public void draw(OptionModel model, TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(model.getColor()));
        graphics.putString(model.getPosition().getX(), model.getPosition().getY(), model.getName(), SGR.BOLD);
    }
}
