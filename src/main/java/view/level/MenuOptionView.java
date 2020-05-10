package view.level;

import model.menu.MenuOption;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class MenuOptionView {
    public void draw(MenuOption model, TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(model.getColor()));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(model.getPosition().getX(), model.getPosition().getY(), model.getName(), SGR.BOLD);
    }
}
