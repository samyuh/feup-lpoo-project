package org.g70.controller.level;

import org.g70.model.Position;
import org.g70.model.drawable.element.immovable.DoubleIce;
import org.g70.model.drawable.element.movable.Puffle;
import org.g70.model.level.LevelHeaderModel;
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
        Assert.assertEquals(levelModel.getWalls().size(), 24);
        Assert.assertEquals(levelModel.getCoins().size(), 0);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 0);

        levelModel.clearLevel(false);
        levelInit.initLevel(2, false);
        Assert.assertEquals(levelModel.getWalls().size(), 52);
        Assert.assertEquals(levelModel.getCoins().size(), 0);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 0);

        levelModel.clearLevel(false);
        levelInit.initLevel(3, false);
        Assert.assertEquals(levelModel.getWalls().size(), 137);
        Assert.assertEquals(levelModel.getCoins().size(), 0);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 8);
        Assert.assertEquals(levelModel.getTeleports().size(), 2);
        Assert.assertNotNull(levelModel.getSecret());
        Assert.assertNotNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getLock());

        levelModel.clearLevel(true);
        levelInit.initLevel(3, true);
        Assert.assertEquals(levelModel.getWalls().size(), 116);
        Assert.assertEquals(levelModel.getCoins().size(), 18);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 8);
        Assert.assertEquals(levelModel.getTeleports().size(), 2);
        Assert.assertNotNull(levelModel.getSecret());
        Assert.assertNotNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getLock());

        levelModel.clearLevel(false);
        levelInit.initLevel(4, false);
        Assert.assertEquals(levelModel.getWalls().size(), 16);
        Assert.assertEquals(levelModel.getCoins().size(), 1);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 0);
        Assert.assertEquals(levelModel.getTeleports().size(), 0);
        Assert.assertNull(levelModel.getSecret());
        Assert.assertNull(levelModel.getBox());
        Assert.assertNull(levelModel.getLock());

        levelModel.clearLevel(false);
        levelInit.initLevel(5, false);
        Assert.assertEquals(levelModel.getWalls().size(), 13);
        Assert.assertEquals(levelModel.getCoins().size(), 0);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 1);
        Assert.assertEquals(levelModel.getTeleports().size(), 0);
        Assert.assertNull(levelModel.getSecret());
        Assert.assertNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getLock());

        levelModel.clearLevel(false);
        levelInit.initLevel(6, false);
        Assert.assertEquals(levelModel.getWalls().size(), 15);
        Assert.assertEquals(levelModel.getCoins().size(), 0);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 0);
        Assert.assertEquals(levelModel.getTeleports().size(), 0);
        Assert.assertNull(levelModel.getSecret());
        Assert.assertNotNull(levelModel.getBox());
        Assert.assertNull(levelModel.getLock());
    }
}