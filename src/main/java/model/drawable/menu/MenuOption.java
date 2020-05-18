package model.drawable.menu;

import controller.menu.option.Option;
import model.Position;
import model.drawable.Drawable;

public class MenuOption extends Drawable {
    Option option;
    
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
