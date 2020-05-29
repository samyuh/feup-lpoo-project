package org.g70.model.level;

import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.leveldrawable.GlobalScore;
import org.g70.model.drawable.leveldrawable.CurrentLevel;
import org.g70.model.drawable.leveldrawable.LevelBlocks;

import java.util.ArrayList;
import java.util.List;

public class LevelHeaderModel {
    private final CurrentLevel levelCurrent;
    private final LevelBlocks levelBlocks;
    private final GlobalScore globalScore;

    static final int[] maxScores = {12, 19, 25, 43, 41, 41, 66, 82, 93, 204, 132,
            138, 128, 131, 227, 181, 161, 179, 172, 172};

    public LevelHeaderModel(int levelNum) {
        levelBlocks = new LevelBlocks(maxScores[levelNum-1]);
        levelCurrent = new CurrentLevel(levelNum);
        globalScore =  new GlobalScore();
    }

    public void setLevelNumber(int levelNum) {
        levelCurrent.setLevel(levelNum);
        levelBlocks.setLevelBlocks(maxScores[levelNum-1]);
    }

    public LevelBlocks getLevelBlocks() {return levelBlocks; }

    public GlobalScore getGlobalScore() {
        return globalScore;
    }

    public void updateHeaderScore(int incBlocks, int incScore){
        levelBlocks.addBlocks(incBlocks);
        globalScore.addScore(incScore);
    }

    public void lockGlobalScore() {
        globalScore.lockScore();
    }

    public void resetGlobalScore() {
        globalScore.resetScore();
    }

    public List<Drawable> getAll() {
        List<Drawable> elements = new ArrayList<>();

        elements.add(levelBlocks);
        elements.add(levelCurrent);
        elements.add(globalScore);

        return elements;
    }
}
