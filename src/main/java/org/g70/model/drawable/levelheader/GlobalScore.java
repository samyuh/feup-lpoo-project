package org.g70.model.drawable.levelheader;

import org.g70.model.Position;
import org.g70.model.drawable.Drawable;

public class GlobalScore extends Drawable {
    private int restartLevelScore;
    private int score;

    public GlobalScore() {
        super("GLOBAL SCORE " + 0,"#000000", "#8dc5f0", new Position(12,18));

        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void lockScore() {
        restartLevelScore = score;
    }

    public void addScore(int number) {
        score += number;

        updateImage();
    }

    public void resetScore() {
        score = restartLevelScore;

        updateImage();
    }

    private void updateImage() {
        image = "GLOBAL SCORE " + score;
    }
}
