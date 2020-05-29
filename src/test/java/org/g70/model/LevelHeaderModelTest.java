package org.g70.model;

import org.g70.controller.level.LevelController;
import org.g70.model.level.LevelHeaderModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LevelHeaderModelTest {
    LevelHeaderModel headerModelTest;

    @Before
    public void initHeader() {
        headerModelTest = new LevelHeaderModel(3);
    }

    @Test
    public void headerScore() {
        Assert.assertEquals(headerModelTest.getGlobalScore().getScore(), 0);

        headerModelTest.updateHeaderScore(0, 10);

        Assert.assertEquals(headerModelTest.getGlobalScore().getScore(), 10);

        headerModelTest.resetGlobalScore();

        Assert.assertEquals(headerModelTest.getGlobalScore().getScore(), 0);

        headerModelTest.updateHeaderScore(0, 10);
        headerModelTest.lockGlobalScore();
        headerModelTest.resetGlobalScore();

        Assert.assertEquals(headerModelTest.getGlobalScore().getScore(), 10);

        Assert.assertEquals(headerModelTest.getAll().size(), 3);
    }

    @Test
    public void headerBlocks() {
        Assert.assertEquals(headerModelTest.getGlobalScore().getScore(), 0);

        headerModelTest.updateHeaderScore(10, 0);

        Assert.assertEquals(headerModelTest.getLevelBlocks().getBlocks(), 10);

        headerModelTest.setLevelNumber(5);

        Assert.assertEquals(headerModelTest.getLevelBlocks().getBlocks(), 0);
    }

}
