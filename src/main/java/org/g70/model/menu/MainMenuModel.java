package org.g70.model.menu;

import org.g70.model.Position;
import org.g70.model.drawable.menu.TextBox;
import org.g70.model.drawable.menu.MenuOption;

import java.util.List;

public class MainMenuModel extends MenuModel {
    public MainMenuModel(List<MenuOption> option) {
        super(option);
        initTextBoxes();
    }

    @Override
    protected void initTextBoxes() {
        textBoxes.add(new TextBox("Frostbite Penguin Madness", "#ffffff", "#000077", new Position(1, 2)));
    }
}
