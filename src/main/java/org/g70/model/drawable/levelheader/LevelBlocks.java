package org.g70.model.drawable.levelheader;

import org.g70.model.Position;
import org.g70.model.drawable.Drawable;

public class LevelBlocks extends Drawable {
    private int blocks;
    private int maxBlocks;

    public LevelBlocks(int maxBlocks) {
        super(0 + "/" + maxBlocks,"#000000", "#8dc5f0", new Position(12,0));

        blocks = 0;
        this.maxBlocks = maxBlocks;
    }

    public void setLevelBlocks(int maxBlocks) {
        blocks = 0;
        this.maxBlocks = maxBlocks;
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
