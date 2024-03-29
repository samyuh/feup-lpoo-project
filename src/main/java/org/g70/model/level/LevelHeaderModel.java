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

    public LevelHeaderModel(int levelNum) {
        levelBlocks = new LevelBlocks(levelNum);
        levelCurrent = new CurrentLevel(levelNum);
        globalScore =  new GlobalScore();
    }

    public CurrentLevel getLevelCurrent() { return levelCurrent; }

    public LevelBlocks getLevelBlocks() {return levelBlocks; }

    public GlobalScore getGlobalScore() {
        return globalScore;
    }

    public void setLevelNumber(int levelNum) {
        levelCurrent.setLevel(levelNum);
        levelBlocks.setLevelNum(levelNum);
    }

    public void updateHeaderScore(int incBlocks, int incScore) {
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
