package org.g70.model.drawable;

import org.g70.model.drawable.leveldrawable.CurrentLevel;
import org.g70.model.drawable.leveldrawable.GlobalScore;
import org.g70.model.drawable.leveldrawable.LevelBlocks;
import org.junit.Assert;
import org.junit.Test;

public class LevelDrawableTest {
    @Test
    public void currentLevel() {
        CurrentLevel currentLevelTest1 = new CurrentLevel(1);
        CurrentLevel currentLevelTest3 = new CurrentLevel(3);

        Assert.assertEquals("LEVEL 1", currentLevelTest1.getImage());
        Assert.assertEquals("LEVEL 3", currentLevelTest3.getImage());

        currentLevelTest1.setLevel(5);
        currentLevelTest3.setLevel(8);
        Assert.assertEquals("LEVEL 5", currentLevelTest1.getImage());
        Assert.assertEquals("LEVEL 8", currentLevelTest3.getImage());
    }

    @Test
    public void globalScore() {
        GlobalScore globalScoreTest = new GlobalScore();

        Assert.assertEquals(0, globalScoreTest.getScore());
        Assert.assertEquals("GLOBAL SCORE 0", globalScoreTest.getImage());

        globalScoreTest.addScore(10);
        Assert.assertEquals(10, globalScoreTest.getScore());
        Assert.assertEquals("GLOBAL SCORE 10", globalScoreTest.getImage());
        globalScoreTest.addScore(-10);
        Assert.assertEquals(0, globalScoreTest.getScore());
        Assert.assertEquals("GLOBAL SCORE 0", globalScoreTest.getImage());

        globalScoreTest.addScore(10);
        Assert.assertEquals("GLOBAL SCORE 10", globalScoreTest.getImage());
        globalScoreTest.lockScore();
        Assert.assertEquals("GLOBAL SCORE 10", globalScoreTest.getImage());
        Assert.assertEquals(10, globalScoreTest.getScore());
        globalScoreTest.resetScore();
        Assert.assertEquals("GLOBAL SCORE 10", globalScoreTest.getImage());
        Assert.assertEquals(10, globalScoreTest.getScore());
        globalScoreTest.addScore(10);
        Assert.assertEquals("GLOBAL SCORE 20", globalScoreTest.getImage());
        Assert.assertEquals(20, globalScoreTest.getScore());
        globalScoreTest.resetScore();
        Assert.assertEquals("GLOBAL SCORE 10", globalScoreTest.getImage());
        Assert.assertEquals(10, globalScoreTest.getScore());
    }

    @Test
    public void levelBlocks() {
        LevelBlocks levelBlockTest = new LevelBlocks(5);
        Assert.assertEquals("0/41", levelBlockTest.getImage());

        levelBlockTest.setLevelNum(1);
        Assert.assertEquals("0/12", levelBlockTest.getImage());

        levelBlockTest.addBlocks(2);
        Assert.assertEquals("2/12", levelBlockTest.getImage());
    }
}
