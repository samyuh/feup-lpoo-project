package Model.Drawable;

import Model.Position;

public class Score extends Drawable{
    private int points;

    public Score(int points) {
        super(Integer.toString(points),"#000000",new Position(20,0));
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
