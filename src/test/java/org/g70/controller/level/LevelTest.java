package org.g70.controller.level;

import org.g70.controller.level.strategy.MeltDoubleIce;
import org.g70.controller.level.strategy.MeltIce;
import org.g70.controller.level.strategy.MeltNothing;
import org.g70.model.drawable.element.immovable.Ice;
import org.g70.model.drawable.element.immovable.Water;
import org.g70.model.drawable.element.movable.Puffle;
import org.g70.model.Position;
import org.g70.model.drawable.element.immovable.Secret;
import org.g70.model.level.LevelHeaderModel;
import org.g70.model.level.LevelModel;
import org.g70.view.game.LevelView;
import org.g70.view.handler.KeyHandler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class LevelTest {
    private LevelModel levelModel;
    private LevelController levelController;
    private LevelHeaderModel headerModel;
    private LevelFacade levelFacade;

    @Before
    public void initLevel() {
        LevelView levelView = Mockito.mock(LevelView.class);
        headerModel = new LevelHeaderModel(1);
        levelModel = new LevelModel();
        levelController = new LevelController(levelModel, headerModel, levelView);
        levelFacade = levelController.getLevelFacade();
    }

    @Test
    public void levelWin() {
        Puffle puffleTest = levelModel.getPuffle();
        Position start = levelModel.getPuffle().getPosition();
        Position finish = levelModel.getFinish().getPosition();

        Assert.assertEquals(puffleTest.getPosition(), start);

        levelController.processCommand(KeyHandler.KEY.UP);

        Assert.assertEquals(puffleTest.getPosition(), start);

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertFalse(levelController.gameFinished());
        Assert.assertEquals(levelController.getLevelNum(), 1);

        levelController.processCommand(KeyHandler.KEY.LEFT);
        levelController.processCommand(KeyHandler.KEY.UP);
        levelController.processCommand(KeyHandler.KEY.DOWN);

        Assert.assertFalse(levelController.gameFinished());
        Assert.assertEquals(levelController.getLevelNum(), 1);

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(puffleTest.getPosition(), finish);
        Assert.assertFalse(levelController.gameFinished());
    }

    @Test
    public void levelLose() {
        levelController.processCommand(KeyHandler.KEY.NEXT);

        Assert.assertEquals(levelController.getLevelNum(), 2);
        Puffle puffleTest = levelModel.getPuffle();


        Position start = new Position(14, 3);
        Position finish = new Position(14, 7);
        Assert.assertEquals(puffleTest.getPosition(), start);

        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.LEFT);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(puffleTest.getPosition(), finish);
        Assert.assertTrue(levelController.gameFinished());
    }

    @Test
    public void puffleCoinInteract() {
        levelController.setLevelNum(4);
        levelController.initRegularLevel(false);
        Assert.assertEquals(levelModel.getIce().size(), 2);

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        int previousScore = headerModel.getGlobalScore().getScore();

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        Assert.assertEquals(levelModel.getIce().size(), 1);
        Assert.assertTrue(levelFacade.getMeltStrategy() instanceof MeltIce);
        int afterCoinScore = headerModel.getGlobalScore().getScore();
        Assert.assertEquals(previousScore + 10, afterCoinScore);

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(levelModel.getCoins().size(), 0);

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        Assert.assertEquals(levelController.getLevelNum(), 5);
    }

    @Test
    public void puffleLevelKeyInteract() {
        levelController.setLevelNum(5);
        levelController.initRegularLevel(false);

        Puffle puffleTest = levelModel.getPuffle();

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Position previousDoor = puffleTest.getPosition();

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(puffleTest.getPosition(),
                previousDoor);

        levelController.processCommand(KeyHandler.KEY.DOWN);
        Assert.assertTrue(levelModel.find(previousDoor) instanceof Ice);

        levelController.processCommand(KeyHandler.KEY.UP);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertTrue(levelFacade.getMeltStrategy() instanceof MeltIce);
        Assert.assertNull(levelModel.getLock());
        Assert.assertNull(levelModel.getKey());

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(levelController.getLevelNum(), 6);
    }

    @Test
    public void puffleBoxInteract() {
        levelController.setLevelNum(6);
        levelController.initRegularLevel(false);

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(levelModel.getIce().size(), 1);

        levelController.processCommand(KeyHandler.KEY.DOWN);

        Assert.assertEquals(levelController.getLevelNum(), 7);
    }

    @Test
    public void levelIceMelt() {
        levelController.setLevelNum(7);
        levelController.initRegularLevel(false);

        Assert.assertTrue(levelFacade.getMeltStrategy() instanceof MeltIce);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 3);
        Assert.assertEquals(levelModel.getIce().size(), 1);

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertTrue(levelFacade.getMeltStrategy() instanceof MeltDoubleIce);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 3);
        Assert.assertEquals(levelModel.getIce().size(), 1);

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertTrue(levelFacade.getMeltStrategy() instanceof MeltDoubleIce);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 2);
        Assert.assertEquals(levelModel.getIce().size(), 2);

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertTrue(levelFacade.getMeltStrategy() instanceof MeltDoubleIce);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 1);
        Assert.assertEquals(levelModel.getIce().size(), 3);

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertTrue(levelFacade.getMeltStrategy() instanceof MeltIce);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 0);
        Assert.assertEquals(levelModel.getIce().size(), 4);

        levelController.processCommand(KeyHandler.KEY.LEFT);

        Assert.assertTrue(levelFacade.getMeltStrategy() instanceof MeltIce);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 0);
        Assert.assertEquals(levelModel.getIce().size(), 3);

        levelController.processCommand(KeyHandler.KEY.LEFT);

        Assert.assertTrue(levelFacade.getMeltStrategy() instanceof MeltIce);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 0);
        Assert.assertEquals(levelModel.getIce().size(), 2);

        levelController.processCommand(KeyHandler.KEY.LEFT);

        Assert.assertTrue(levelFacade.getMeltStrategy() instanceof MeltIce);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 0);
        Assert.assertEquals(levelModel.getIce().size(), 1);

        levelController.processCommand(KeyHandler.KEY.DOWN);

        Assert.assertEquals(levelController.getLevelNum(), 8);
    }

    @Test
    public void puffleEmptyBlockInteract() {
        levelController.setLevelNum(8);
        levelController.initRegularLevel(false);

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        Assert.assertTrue(levelFacade.getMeltStrategy() instanceof MeltNothing);
        levelController.processCommand(KeyHandler.KEY.UP);
        Assert.assertTrue(levelFacade.getMeltStrategy() instanceof MeltIce);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.LEFT);
        Assert.assertTrue(levelFacade.getMeltStrategy() instanceof MeltNothing);

        Assert.assertEquals(levelModel.getIce().size(), 0);

        levelController.processCommand(KeyHandler.KEY.DOWN);

        Assert.assertEquals(levelController.getLevelNum(), 9);
    }

    @Test
    public void teleportBoxWin() {
        levelController.setLevelNum(9);
        levelController.initRegularLevel(false);

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(levelModel.getIce().size(), 1);

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(levelModel.getIce().size(), 1);

        levelController.processCommand(KeyHandler.KEY.DOWN);

        Assert.assertEquals(levelController.getLevelNum(), 10);
    }

    @Test
    public void teleportBoxLose() {
        levelController.setLevelNum(10);
        levelController.initRegularLevel(false);

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertTrue(levelController.gameFinished());
    }

    @Test
    public void levelProcessCommandTest() {
        Assert.assertEquals(levelController.processCommand(KeyHandler.KEY.NEXT), true);
        Assert.assertEquals(levelController.processCommand(KeyHandler.KEY.RESTART), true);
        Assert.assertEquals(levelController.processCommand(KeyHandler.KEY.UP), true);
        Assert.assertEquals(levelController.processCommand(KeyHandler.KEY.DOWN), true);
        Assert.assertEquals(levelController.processCommand(KeyHandler.KEY.LEFT), true);
        Assert.assertEquals(levelController.processCommand(KeyHandler.KEY.RIGHT), true);
        Assert.assertEquals(levelController.processCommand(KeyHandler.KEY.CLOSE), false);
    }
}
