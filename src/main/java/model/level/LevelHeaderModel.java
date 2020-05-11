package model.level;

import model.drawable.levelheader.LevelCurrent;
import model.drawable.levelheader.LevelScore;

public class LevelHeaderModel {
    private LevelScore levelScore;
    private LevelCurrent levelCurrent;

    private int maxScores[] = {12, 19, 25, 43, 41, 41, 66, 82, 93, 208, 132,
            138, 128, 131, 227, 181, 161, 179, 172, 172};

    public LevelScore getLevelScore() {
        return levelScore;
    }

    public void addScore(int number) {
        this.levelScore.addPoints(number);
    }

    public LevelCurrent getLevelCurrent() {
        return levelCurrent;
    }

    public void setLevelCurrent(LevelCurrent levelCurrent) {
        this.levelCurrent = levelCurrent;
    }

    public LevelHeaderModel(LevelCurrent levelCurrent) {
        this.levelScore = new LevelScore(maxScores[levelCurrent.getLevelNumber()-1]);
        this.levelCurrent = levelCurrent;
    }
}
