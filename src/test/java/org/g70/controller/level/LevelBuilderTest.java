package org.g70.controller.level;

import org.g70.model.level.LevelModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LevelBuilderTest {
    private LevelModel levelModel;
    private LevelBuilder levelInit;

    @Before
    public void initLevel() {
        levelModel = new LevelModel();
        levelInit = new LevelBuilder(levelModel);
    }

    @Test
    public void levelBuilderTest() {
        levelModel.clearLevel(false);
        levelInit.initLevel(1, false);
        Assert.assertEquals(24, levelModel.getWalls().size());
        Assert.assertEquals(0, levelModel.getCoins().size());
        Assert.assertEquals(0, levelModel.getDoubleIce().size());

        levelModel.clearLevel(false);
        levelInit.initLevel(2, false);
        Assert.assertEquals(52, levelModel.getWalls().size());
        Assert.assertEquals(0, levelModel.getCoins().size());
        Assert.assertEquals(0, levelModel.getCoins().size());
    }
}