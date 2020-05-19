package model.level;

import model.drawable.levelheader.GlobalScore;
import model.drawable.levelheader.LevelCurrent;
import model.drawable.levelheader.LevelScore;

public class LevelHeaderModel {
    private LevelScore levelScore;
    private LevelCurrent levelCurrent;
    private GlobalScore globalScore;

    public LevelHeaderModel(LevelCurrent levelCurrent, int globalScore) {
        int[] maxScores = {12, 19, 25, 43, 41, 41, 66, 82, 93, 204, 132,
                138, 128, 131, 227, 181, 161, 179, 172, 172};

        this.levelScore = new LevelScore(maxScores[levelCurrent.getLevelNumber()-1]);
        this.levelCurrent = levelCurrent;
        this.globalScore =  new GlobalScore(globalScore);
    }

    public LevelScore getLevelScore() {
        return levelScore;
    }

    public void addScore(int levelPoints, int globalPoints){
        this.levelScore.addPoints(levelPoints);
        this.globalScore.addPoints(globalPoints);
    }

    public LevelCurrent getLevelCurrent() {
        return levelCurrent;
    }

    public void setLevelCurrent(LevelCurrent levelCurrent) {
        this.levelCurrent = levelCurrent;
    }

    public GlobalScore getGlobalScore() {
        return globalScore;
    }
}
