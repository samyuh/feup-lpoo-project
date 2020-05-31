package org.g70.model;

import org.g70.model.level.LevelHeaderModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LevelHeaderModelTest {
    private LevelHeaderModel headerModelTest;

    @Before
    public void initHeader() {
        headerModelTest = new LevelHeaderModel(3);
    }

    @Test
    public void headerScore() {
        Assert.assertEquals(0, headerModelTest.getGlobalScore().getScore());

        headerModelTest.updateHeaderScore(0, 10);

        Assert.assertEquals(10, headerModelTest.getGlobalScore().getScore());

        headerModelTest.resetGlobalScore();

        Assert.assertEquals(0, headerModelTest.getGlobalScore().getScore());

        headerModelTest.updateHeaderScore(0, 10);
        headerModelTest.lockGlobalScore();
        headerModelTest.resetGlobalScore();

        Assert.assertEquals(10, headerModelTest.getGlobalScore().getScore());
        headerModelTest.updateHeaderScore(0, 10);
        Assert.assertEquals(20, headerModelTest.getGlobalScore().getScore());
        headerModelTest.resetGlobalScore();
        Assert.assertEquals(10, headerModelTest.getGlobalScore().getScore());
        Assert.assertEquals(3, headerModelTest.getAll().size());
    }

    @Test
    public void headerBlocks() {
        Assert.assertEquals(0, headerModelTest.getGlobalScore().getScore());

        headerModelTest.updateHeaderScore(10, 0);

        Assert.assertEquals(10, headerModelTest.getLevelBlocks().getBlocks());

        headerModelTest.setLevelNumber(5);

        Assert.assertEquals(0, headerModelTest.getLevelBlocks().getBlocks());
        Assert.assertEquals(41, headerModelTest.getLevelBlocks().getMaxBlocks());
    }

    @Test
    public void currentLevel() {
        headerModelTest.setLevelNumber(5);
        Assert.assertEquals(5, headerModelTest.getLevelCurrent().getLevelNumber());

        headerModelTest.setLevelNumber(6);
        Assert.assertEquals(6, headerModelTest.getLevelCurrent().getLevelNumber());
    }

}
