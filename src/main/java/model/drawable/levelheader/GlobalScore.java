package model.drawable.levelheader;

import model.Position;
import model.drawable.Drawable;

public class GlobalScore extends Drawable {
    private int restartLevelScore;
    private int score;

    public GlobalScore() {
        super("GLOBAL SCORE " + 0,"#000000", "#8dc5f0", new Position(12,18));
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void lockScore() {
        this.restartLevelScore = score;
    }

    public void addScore(int number) {
        this.score += number;

        updateImage();
    }

    public void resetScore() {
        this.score = restartLevelScore;

        updateImage();
    }

    private void updateImage() {
        this.image = "GLOBAL SCORE " + this.score;
    }
}
