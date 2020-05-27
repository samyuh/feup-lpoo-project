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

        Assert.assertEquals(currentLevelTest1.getImage(), "LEVEL 1");
        Assert.assertEquals(currentLevelTest3.getImage(), "LEVEL 3");

        currentLevelTest1.setLevel(5);
        currentLevelTest3.setLevel(8);
        Assert.assertEquals(currentLevelTest1.getImage(), "LEVEL 5");
        Assert.assertEquals(currentLevelTest3.getImage(), "LEVEL 8");
    }

    @Test
    public void globalScore() {
        GlobalScore globalScoreTest = new GlobalScore();

        Assert.assertEquals(globalScoreTest.getScore(), 0);
        Assert.assertEquals(globalScoreTest.getImage(), "GLOBAL SCORE 0");

        globalScoreTest.addScore(10);
        Assert.assertEquals(globalScoreTest.getScore(), 10);
        Assert.assertEquals(globalScoreTest.getImage(), "GLOBAL SCORE 10");
        globalScoreTest.addScore(-10);
        Assert.assertEquals(globalScoreTest.getScore(), 0);
        Assert.assertEquals(globalScoreTest.getImage(), "GLOBAL SCORE 0");

        globalScoreTest.addScore(10);
        Assert.assertEquals(globalScoreTest.getImage(), "GLOBAL SCORE 10");
        globalScoreTest.lockScore();
        Assert.assertEquals(globalScoreTest.getScore(), 10);
        globalScoreTest.resetScore();
        Assert.assertEquals(globalScoreTest.getScore(), 10);
        globalScoreTest.addScore(10);
        Assert.assertEquals(globalScoreTest.getScore(), 20);
        globalScoreTest.resetScore();
        Assert.assertEquals(globalScoreTest.getScore(), 10);
    }

    @Test
    public void levelBlocks() {
        LevelBlocks levelBlockTest = new LevelBlocks(12345);
        Assert.assertEquals(levelBlockTest.getImage(), "0/12345");

        levelBlockTest.setLevelBlocks(123);
        Assert.assertEquals(levelBlockTest.getImage(), "0/123");

        levelBlockTest.addBlocks(10);
        Assert.assertEquals(levelBlockTest.getImage(), "10/123");
    }
}
