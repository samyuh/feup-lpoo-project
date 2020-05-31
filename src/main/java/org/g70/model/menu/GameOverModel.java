package org.g70.model.menu;

import org.g70.model.Position;
import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.menudrawable.MenuOption;

import java.util.List;

public class GameOverModel extends MenuFactory {
    int globalScore;

    public GameOverModel(List<MenuOption> option, int globalScore) {
        super(option);

        this.globalScore = globalScore;
        initTextBoxes();
    }

    @Override
    protected void initTextBoxes() {
        textBoxes.add(new Drawable("Frostbite Penguin Madness", "#ffffff", "#000077", new Position(1, 2)));
        textBoxes.add(new Drawable("Game Over", "#ffffff", "#000077", new Position(1, 4)));
        textBoxes.add(new Drawable("Score: " + this.globalScore, "#ffffff", "#000077", new Position(1, 6)));
    }
}
