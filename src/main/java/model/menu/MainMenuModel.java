package model.menu;

import model.Position;
import model.drawable.menu.TextBox;
import model.drawable.menu.MenuOption;

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
