package org.g70.model.menu;

import org.g70.model.Position;
import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.menudrawable.MenuOption;

import java.util.List;

public class MainMenuModel extends MenuFactory {
    public MainMenuModel(List<MenuOption> option) {
        super(option);

        initTextBoxes();
    }

    @Override
    protected void initTextBoxes() {
        textBoxes.add(new Drawable("Frostbite Penguin Madness", "#ffffff", "#000077", new Position(1, 2)));
    }
}
