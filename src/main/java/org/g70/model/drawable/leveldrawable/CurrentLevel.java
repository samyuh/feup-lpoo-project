package org.g70.model.drawable.leveldrawable;

import org.g70.model.Position;
import org.g70.model.drawable.Drawable;

public class CurrentLevel extends Drawable {
    private int levelNumber;

    public CurrentLevel(int levelNumber) {
        super("LEVEL " + levelNumber,"#000000", "#8dc5f0", new Position(2,0));

        this.levelNumber = levelNumber;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevel(int levelNumber) {
        this.levelNumber = levelNumber;

        updateImage();
    }

    private void updateImage() {
        image = "LEVEL " + levelNumber;
    }
}
