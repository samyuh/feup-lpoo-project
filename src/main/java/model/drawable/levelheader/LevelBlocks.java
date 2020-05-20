package model.drawable.levelheader;

import model.Position;
import model.drawable.Drawable;

public class LevelBlocks extends Drawable {
    private int blocks;
    private int maxBlocks;

    public LevelBlocks(int maxBlocks) {
        super(0 + "/" + maxBlocks,"#000000", "#8dc5f0", new Position(12,0));
        this.blocks = 0;
        this.maxBlocks = maxBlocks;
    }

    public void setLevelBlocks(int maxBlocks) {
        this.blocks = 0;
        this.maxBlocks = maxBlocks;

        updateImage();
    }

    public void addBlocks(int number){
        this.blocks += number;

        updateImage();
    }

    private void updateImage() {
        this.image = blocks + "/" + maxBlocks;
    }
}
