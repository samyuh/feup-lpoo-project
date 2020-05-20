package model.menu;

import model.Position;
import model.drawable.menu.MenuOption;
import model.drawable.menu.TextBox;

import java.util.List;

public class GameOverModel extends MenuModel {
    int globalScore;

    public GameOverModel(List<MenuOption> option, int globalScore) {
        super(option);

        this.globalScore = globalScore;

        initTextBoxes();
    }

    @Override
    public void initTextBoxes() {
        textBoxes.add(new TextBox("Frostbite Penguin Madness", "#ffffff", "#000077", new Position(1, 2)));
        textBoxes.add(new TextBox("Game Over", "#ffffff", "#000077", new Position(1, 4)));
        textBoxes.add(new TextBox("Score: " + this.globalScore, "#ffffff", "#000077", new Position(1, 6)));
    }
}
