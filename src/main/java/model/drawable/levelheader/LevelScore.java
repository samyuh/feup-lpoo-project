package model.drawable.levelheader;

import model.Position;
import model.drawable.Drawable;

public class LevelScore extends Drawable {
    private int points;
    private int maxPoints;

    public LevelScore(int maxPoints) {
        super(0 + "/" + maxPoints,"#000000", "#8dc5f0", new Position(12,0));
        this.points = 0;
        this.maxPoints = maxPoints;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int number){
        this.points += number;
        this.image = points + "/" + maxPoints;
    }
}
