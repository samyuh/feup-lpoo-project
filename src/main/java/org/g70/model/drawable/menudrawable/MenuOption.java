package org.g70.model.drawable.menudrawable;

import org.g70.controller.menu.option.Option;
import org.g70.model.Position;
import org.g70.model.drawable.Drawable;

public class MenuOption extends Drawable {
    private Option option;
    
    public MenuOption(String image, Position position, Option option) {
        super(image, "#FFFFFF", "#000077", position);
        this.option = option;
    }

    public Option getCommandOption() {
        return option;
    }

    public void resetColor() {
        setColorBackground("#000077");
    }

    public void highlightedColor() {
        setColorBackground("#120A8F");
    }
}
