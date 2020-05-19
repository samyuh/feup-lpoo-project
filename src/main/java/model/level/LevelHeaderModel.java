package model.level;

import jdk.nashorn.internal.objects.Global;
import model.drawable.levelheader.GlobalScore;
import model.drawable.levelheader.LevelCurrent;
import model.drawable.levelheader.LevelScore;

public class LevelHeaderModel {
    private LevelScore levelScore;
    private LevelCurrent levelCurrent;
    private GlobalScore globalScore;

    private int maxScores[] = {12, 19, 25, 43, 41, 41, 66, 82, 93, 208, 132,
            138, 128, 131, 227, 181, 161, 179, 172, 172};

    public LevelScore getLevelScore() {
        return levelScore;
    }

    public void addScore(int levelpoints, int globalPoints){
        this.levelScore.addPoints(levelpoints);
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

    public LevelHeaderModel(LevelCurrent levelCurrent, int globalScore) {
        this.levelScore = new LevelScore(maxScores[levelCurrent.getLevelNumber()-1]);
        this.levelCurrent = levelCurrent;
        this.globalScore =  new GlobalScore(globalScore);
    }
}
