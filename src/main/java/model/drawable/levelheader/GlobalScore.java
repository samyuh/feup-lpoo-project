package model.drawable.levelheader;

import model.Position;
import model.drawable.Drawable;

public class GlobalScore extends Drawable {
    private int points;

    public GlobalScore(int points) {
        super("GLOBAL SCORE " + points,"#000000", "#8dc5f0", new Position(12,18));
        this.points = points;
    }

    public void addPoints(int number){
        this.points += number;
        this.image = "GLOBAL SCORE " + points;
    }

    public int getPoints() {
        return points;
    }
}
