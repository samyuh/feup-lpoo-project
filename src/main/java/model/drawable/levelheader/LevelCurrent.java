package model.drawable.levelheader;

import model.Position;
import model.drawable.Drawable;

public class LevelCurrent extends Drawable {
    private int levelNumber;

    public LevelCurrent(int levelNumber) {
        super("LEVEL " + levelNumber,"#000000", "#8dc5f0", new Position(2,0));
        this.levelNumber = levelNumber;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public void increment(){
        this.levelNumber++;
    }
}
