package model.drawable;

import model.Position;

public class Score extends Drawable{
    private int points;
    private int maxPoints;

    public Score(int maxPoints) {
        super(0 + "/" + maxPoints ,"#000000",new Position(12,0));
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
