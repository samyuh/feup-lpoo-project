package model.level;

import model.drawable.Drawable;
import model.drawable.levelheader.GlobalScore;
import model.drawable.levelheader.CurrentLevel;
import model.drawable.levelheader.LevelBlocks;

import java.util.ArrayList;
import java.util.List;

public class LevelHeaderModel {
    private final CurrentLevel levelCurrent;
    private final LevelBlocks levelBlocks;
    private final GlobalScore globalScore;

    int[] maxScores = {12, 19, 25, 43, 41, 41, 66, 82, 93, 204, 132,
            138, 128, 131, 227, 181, 161, 179, 172, 172};

    public LevelHeaderModel(int levelNum) {
        this.levelBlocks = new LevelBlocks(maxScores[levelNum-1]);
        this.levelCurrent = new CurrentLevel(levelNum);
        this.globalScore =  new GlobalScore();
    }

    // --- Current Level --- //
    public void setLevelNumber(int levelNum) {
        this.levelCurrent.setLevel(levelNum);

        this.levelBlocks.setLevelBlocks(maxScores[levelNum-1]);
    }

    // --- Score --- //
    public GlobalScore getGlobalScore() {
        return globalScore;
    }

    public void updateHeader(int incBlocks, int incScore){
        this.levelBlocks.addBlocks(incBlocks);
        this.globalScore.addScore(incScore);
    }

    public void lockGlobalScore() {
        this.globalScore.lockScore();
    }

    public void resetGlobalScore() {
        this.globalScore.resetScore();
    }

    // --- Draw --- //
    public List<Drawable> getAll() {
        List<Drawable> elements = new ArrayList<>();

        elements.add(levelBlocks);
        elements.add(levelCurrent);
        elements.add(globalScore);

        return elements;
    }
}
