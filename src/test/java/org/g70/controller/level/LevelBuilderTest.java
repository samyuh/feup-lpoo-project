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
        Assert.assertEquals(7, levelModel.getIce().size());
        Assert.assertEquals(0, levelModel.getInvisibleWalls().size());
        Assert.assertEquals(24, levelModel.getWalls().size());
        Assert.assertEquals(0, levelModel.getCoins().size());
        Assert.assertEquals(0, levelModel.getDoubleIce().size());
        Assert.assertEquals(0, levelModel.getTeleports().size());
        Assert.assertNotNull(levelModel.getFinish());
        Assert.assertNull(levelModel.getKey());
        Assert.assertNull(levelModel.getLock());
        Assert.assertNull(levelModel.getSecret());
        Assert.assertNull(levelModel.getEmptyBlock());
        Assert.assertNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getPuffle());

        levelModel.clearLevel(false);
        levelInit.initLevel(2, false);
        Assert.assertEquals(24, levelModel.getIce().size());
        Assert.assertEquals(0, levelModel.getInvisibleWalls().size());
        Assert.assertEquals(52, levelModel.getWalls().size());
        Assert.assertEquals(0, levelModel.getCoins().size());
        Assert.assertEquals(0, levelModel.getDoubleIce().size());
        Assert.assertEquals(0, levelModel.getTeleports().size());
        Assert.assertNotNull(levelModel.getFinish());
        Assert.assertNull(levelModel.getKey());
        Assert.assertNull(levelModel.getLock());
        Assert.assertNull(levelModel.getSecret());
        Assert.assertNull(levelModel.getEmptyBlock());
        Assert.assertNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getPuffle());

        levelModel.clearLevel(false);
        levelInit.initLevel(3, false);
        Assert.assertEquals(2, levelModel.getIce().size());
        Assert.assertEquals(4, levelModel.getInvisibleWalls().size());
        Assert.assertEquals(35, levelModel.getWalls().size());
        Assert.assertEquals(0, levelModel.getCoins().size());
        Assert.assertEquals(1, levelModel.getDoubleIce().size());
        Assert.assertEquals(0, levelModel.getTeleports().size());
        Assert.assertNotNull(levelModel.getFinish());
        Assert.assertNull(levelModel.getKey());
        Assert.assertNull(levelModel.getLock());
        Assert.assertNotNull(levelModel.getSecret());
        Assert.assertNull(levelModel.getEmptyBlock());
        Assert.assertNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getPuffle());

        levelModel.clearLevel(true);
        levelInit.initLevel(3, true);
        Assert.assertEquals(8, levelModel.getIce().size());
        Assert.assertEquals(0, levelModel.getInvisibleWalls().size());
        Assert.assertEquals(34, levelModel.getWalls().size());
        Assert.assertEquals(0, levelModel.getCoins().size());
        Assert.assertEquals(1, levelModel.getDoubleIce().size());
        Assert.assertEquals(0, levelModel.getTeleports().size());
        Assert.assertNotNull(levelModel.getFinish());
        Assert.assertNull(levelModel.getKey());
        Assert.assertNull(levelModel.getLock());
        Assert.assertNotNull(levelModel.getSecret());
        Assert.assertNull(levelModel.getEmptyBlock());
        Assert.assertNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getPuffle());

        levelModel.clearLevel(false);
        levelInit.initLevel(4, false);
        Assert.assertEquals(2, levelModel.getIce().size());
        Assert.assertEquals(0, levelModel.getInvisibleWalls().size());
        Assert.assertEquals(16, levelModel.getWalls().size());
        Assert.assertEquals(1, levelModel.getCoins().size());
        Assert.assertEquals(0, levelModel.getDoubleIce().size());
        Assert.assertEquals(0, levelModel.getTeleports().size());
        Assert.assertNotNull(levelModel.getFinish());
        Assert.assertNull(levelModel.getKey());
        Assert.assertNull(levelModel.getLock());
        Assert.assertNull(levelModel.getSecret());
        Assert.assertNull(levelModel.getEmptyBlock());
        Assert.assertNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getPuffle());

        levelModel.clearLevel(false);
        levelInit.initLevel(5, false);
        Assert.assertEquals(0, levelModel.getIce().size());
        Assert.assertEquals(0, levelModel.getInvisibleWalls().size());
        Assert.assertEquals(13, levelModel.getWalls().size());
        Assert.assertEquals(0, levelModel.getCoins().size());
        Assert.assertEquals(1, levelModel.getDoubleIce().size());
        Assert.assertEquals(0, levelModel.getTeleports().size());
        Assert.assertNotNull(levelModel.getFinish());
        Assert.assertNotNull(levelModel.getKey());
        Assert.assertNotNull(levelModel.getLock());
        Assert.assertNull(levelModel.getSecret());
        Assert.assertNull(levelModel.getEmptyBlock());
        Assert.assertNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getPuffle());

        levelModel.clearLevel(false);
        levelInit.initLevel(6, false);
        Assert.assertEquals(5, levelModel.getIce().size());
        Assert.assertEquals(0, levelModel.getInvisibleWalls().size());
        Assert.assertEquals(26, levelModel.getWalls().size());
        Assert.assertEquals(0, levelModel.getCoins().size());
        Assert.assertEquals(1, levelModel.getDoubleIce().size());
        Assert.assertEquals(0, levelModel.getTeleports().size());
        Assert.assertNotNull(levelModel.getFinish());
        Assert.assertNull(levelModel.getKey());
        Assert.assertNull(levelModel.getLock());
        Assert.assertNull(levelModel.getSecret());
        Assert.assertNotNull(levelModel.getEmptyBlock());
        Assert.assertNotNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getPuffle());

        levelModel.clearLevel(false);
        levelInit.initLevel(7, false);
        Assert.assertEquals(1, levelModel.getIce().size());
        Assert.assertEquals(0, levelModel.getInvisibleWalls().size());
        Assert.assertEquals(15, levelModel.getWalls().size());
        Assert.assertEquals(0, levelModel.getCoins().size());
        Assert.assertEquals(3, levelModel.getDoubleIce().size());
        Assert.assertEquals(0, levelModel.getTeleports().size());
        Assert.assertNotNull(levelModel.getFinish());
        Assert.assertNull(levelModel.getKey());
        Assert.assertNull(levelModel.getLock());
        Assert.assertNull(levelModel.getSecret());
        Assert.assertNull(levelModel.getEmptyBlock());
        Assert.assertNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getPuffle());

        levelModel.clearLevel(false);
        levelInit.initLevel(8, false);
        Assert.assertEquals(5, levelModel.getIce().size());
        Assert.assertEquals(0, levelModel.getInvisibleWalls().size());
        Assert.assertEquals(31, levelModel.getWalls().size());
        Assert.assertEquals(0, levelModel.getCoins().size());
        Assert.assertEquals(1, levelModel.getDoubleIce().size());
        Assert.assertEquals(0, levelModel.getTeleports().size());
        Assert.assertNotNull(levelModel.getFinish());
        Assert.assertNull(levelModel.getKey());
        Assert.assertNull(levelModel.getLock());
        Assert.assertNull(levelModel.getSecret());
        Assert.assertNotNull(levelModel.getEmptyBlock());
        Assert.assertNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getPuffle());

        levelModel.clearLevel(false);
        levelInit.initLevel(9, false);
        Assert.assertEquals(4, levelModel.getIce().size());
        Assert.assertEquals(0, levelModel.getInvisibleWalls().size());
        Assert.assertEquals(24, levelModel.getWalls().size());
        Assert.assertEquals(0, levelModel.getCoins().size());
        Assert.assertEquals(0, levelModel.getDoubleIce().size());
        Assert.assertEquals(2, levelModel.getTeleports().size());
        Assert.assertNotNull(levelModel.getFinish());
        Assert.assertNull(levelModel.getKey());
        Assert.assertNull(levelModel.getLock());
        Assert.assertNull(levelModel.getSecret());
        Assert.assertNotNull(levelModel.getEmptyBlock());
        Assert.assertNotNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getPuffle());

        levelModel.clearLevel(false);
        levelInit.initLevel(10, false);
        Assert.assertEquals(4, levelModel.getIce().size());
        Assert.assertEquals(0, levelModel.getInvisibleWalls().size());
        Assert.assertEquals(24, levelModel.getWalls().size());
        Assert.assertEquals(0, levelModel.getCoins().size());
        Assert.assertEquals(0, levelModel.getDoubleIce().size());
        Assert.assertEquals(2, levelModel.getTeleports().size());
        Assert.assertNotNull(levelModel.getFinish());
        Assert.assertNull(levelModel.getKey());
        Assert.assertNull(levelModel.getLock());
        Assert.assertNull(levelModel.getSecret());
        Assert.assertNotNull(levelModel.getEmptyBlock());
        Assert.assertNotNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getPuffle());

        levelModel.clearLevel(false);
        levelInit.initLevel(11, false);
        Assert.assertEquals(2, levelModel.getIce().size());
        Assert.assertEquals(1, levelModel.getInvisibleWalls().size());
        Assert.assertEquals(1, levelModel.getWalls().size());
        Assert.assertEquals(1, levelModel.getCoins().size());
        Assert.assertEquals(1, levelModel.getDoubleIce().size());
        Assert.assertEquals(1, levelModel.getTeleports().size());
        Assert.assertNotNull(levelModel.getFinish());
        Assert.assertNotNull(levelModel.getKey());
        Assert.assertNotNull(levelModel.getLock());
        Assert.assertNotNull(levelModel.getSecret());
        Assert.assertNotNull(levelModel.getEmptyBlock());
        Assert.assertNotNull(levelModel.getBox());
        Assert.assertNotNull(levelModel.getPuffle());

    }
}