package org.g70.model.drawable.leveldrawable;

import org.g70.model.Position;
import org.g70.model.drawable.Drawable;

public class LevelBlocks extends Drawable {
    private int blocks;
    private int maxBlocks;

    static final int[] maxScores = {12, 19, 25, 43, 41, 41, 66, 82, 93, 204, 132,
            138, 128, 131, 227, 181, 161, 179, 172, 172};

    public LevelBlocks(int levelNum) {
        super(0 + "/" + 0,"#000000", "#8dc5f0", new Position(12,0));

        blocks = 0;
        maxBlocks = maxScores[levelNum-1];
        updateImage();
    }

    public int getBlocks() {
        return blocks;
    }

    public int getMaxBlocks() {
        return maxBlocks;
    }

    public void setLevelNum(int levelNum) {
        blocks = 0;
        maxBlocks = maxScores[levelNum-1];
        updateImage();
    }

    public void addBlocks(int number){
        blocks += number;
        updateImage();
    }

    private void updateImage() {
        image = blocks + "/" + maxBlocks;
    }
}
