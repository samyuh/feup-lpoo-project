package model.drawable;

public class LevelOptions {
    private int maxScores[] = {12,19,25,43,41,41,66,82,93,208,132,138,128,131,227,181,161,179,172,172};
    private Score score;
    private CurrentLevel currentLevel;

    public Score getScore() {
        return score;
    }

    public void addScore(int number) {
        this.score.addPoints(number);
    }

    public CurrentLevel getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(CurrentLevel currentLevel) {
        this.currentLevel = currentLevel;
    }

    public LevelOptions(CurrentLevel currentLevel) {
        this.score = new Score(maxScores[currentLevel.getLevelNumber()-1]);
        this.currentLevel = currentLevel;
    }
}
