package model.drawable.levelheader;

import model.Position;
import model.drawable.Drawable;

public class CurrentLevel extends Drawable {
    private int levelNumber;

    public CurrentLevel(int levelNumber) {
        super("LEVEL " + levelNumber,"#000000", "#8dc5f0", new Position(2,0));
        this.levelNumber = levelNumber;
    }

    public void setLevel(int levelNum) {
        this.levelNumber = levelNum;

        updateImage();
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    private void updateImage() {
        this.image = "LEVEL " + levelNumber;
    }
}
