package Model.Drawable;

import Model.Drawable.CurrentLevel;
import Model.Drawable.Score;

public class LevelOptions {
    private Score score;
    private CurrentLevel currentLevel;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public CurrentLevel getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(CurrentLevel currentLevel) {
        this.currentLevel = currentLevel;
    }

    public LevelOptions(Score score, CurrentLevel currentLevel) {
        this.score = score;
        this.currentLevel = currentLevel;
    }
}
