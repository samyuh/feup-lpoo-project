package Model.Drawable;

import Model.Position;

public class CurrentLevel extends Drawable {

    private int levelNumber;


    public CurrentLevel(int levelNumber) {
        super("LEVEL " + levelNumber,"#000000",new Position(2,0));
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
