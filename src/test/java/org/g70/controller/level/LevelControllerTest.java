package org.g70.controller.level;

import org.g70.controller.level.interact.InteractBox;
import org.g70.controller.level.interact.InteractStop;
import org.g70.controller.level.strategy.MeltDoubleIce;
import org.g70.controller.level.strategy.MeltIce;
import org.g70.controller.level.strategy.MeltNothing;
import org.g70.model.drawable.element.immovable.Ice;
import org.g70.model.drawable.element.movable.Puffle;
import org.g70.model.Position;
import org.g70.model.level.LevelHeaderModel;
import org.g70.model.level.LevelModel;
import org.g70.view.game.LevelView;
import org.g70.view.handler.KeyHandler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class LevelControllerTest {
    private LevelModel levelModel;
    private LevelController levelController;
    private LevelHeaderModel headerModel;
    private LevelElementController levelElementController;

    @Before
    public void initLevel() {
        LevelView levelView = Mockito.mock(LevelView.class);
        headerModel = new LevelHeaderModel(1);
        levelModel = new LevelModel();
        levelController = new LevelController(levelModel, headerModel, levelView);
        levelElementController = levelController.getLevelElementController();
    }

    @Test
    public void levelWin() {
        levelController.setLevelNum(1);
        levelController.initRegularLevel(false);

        Puffle puffleTest = levelModel.getPuffle();
        Position start = levelModel.getPuffle().getPosition();
        Position finish = levelModel.getFinish().getPosition();

        Assert.assertEquals(start, puffleTest.getPosition());

        levelController.processCommand(KeyHandler.KEY.UP);

        Assert.assertEquals(start, puffleTest.getPosition());

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertFalse(levelController.gameFinished());
        Assert.assertEquals(1, levelController.getLevelNum());

        levelController.processCommand(KeyHandler.KEY.LEFT);
        levelController.processCommand(KeyHandler.KEY.UP);
        levelController.processCommand(KeyHandler.KEY.DOWN);

        Assert.assertFalse(levelController.gameFinished());
        Assert.assertEquals(1, levelController.getLevelNum());

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(finish, puffleTest.getPosition());
        Assert.assertFalse(levelController.gameFinished());
    }

    @Test
    public void levelLose() {
        levelController.setLevelNum(2);
        levelController.initRegularLevel(false);

        Puffle puffleTest = levelModel.getPuffle();

        Position start = new Position(14, 3);
        Position finish = new Position(14, 7);
        Assert.assertEquals(start, puffleTest.getPosition());

        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.LEFT);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        Assert.assertFalse(levelController.gameFinished());

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(finish, puffleTest.getPosition());
        Assert.assertTrue(levelController.gameFinished());
    }

    @Test
    public void restartLevel() {
        levelController.setLevelNum(1);
        levelController.initRegularLevel(false);

        Assert.assertEquals(0, headerModel.getGlobalScore().getScore());
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        Assert.assertEquals(2, headerModel.getGlobalScore().getScore());

        levelController.processCommand(KeyHandler.KEY.RESTART);
        Assert.assertEquals(0, headerModel.getGlobalScore().getScore());
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        Assert.assertEquals(2, headerModel.getGlobalScore().getScore());

        levelController.processCommand(KeyHandler.KEY.NEXT);
        Assert.assertEquals(2, headerModel.getGlobalScore().getScore());
        levelController.processCommand(KeyHandler.KEY.DOWN);
        Assert.assertEquals(3, headerModel.getGlobalScore().getScore());

        levelController.processCommand(KeyHandler.KEY.RESTART);
        Assert.assertEquals(2, headerModel.getGlobalScore().getScore());
    }

    @Test
    public void testNextLevel() {
        levelController.setLevelNum(1);
        levelController.initRegularLevel(false);
        Assert.assertEquals(1, levelController.getLevelNum());

        levelController.processCommand(KeyHandler.KEY.NEXT);
        levelController.initRegularLevel(false);
        Assert.assertEquals(2, levelController.getLevelNum());

        levelController.processCommand(KeyHandler.KEY.NEXT);
        levelController.initRegularLevel(false);
        Assert.assertEquals(3, levelController.getLevelNum());
    }

    @Test
    public void testLevelSecret() {
        levelController.setLevelNum(3);
        levelController.initRegularLevel(false);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Position prevSecret = levelModel.getPuffle().getPosition();

        levelController.processCommand(KeyHandler.KEY.LEFT);

        Assert.assertEquals(prevSecret, levelModel.getPuffle().getPosition());
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.LEFT);
        levelController.processCommand(KeyHandler.KEY.LEFT);
        levelController.processCommand(KeyHandler.KEY.LEFT);
        levelController.processCommand(KeyHandler.KEY.LEFT);
        levelController.processCommand(KeyHandler.KEY.LEFT);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.LEFT);

        levelController.processCommand(KeyHandler.KEY.DOWN);
        Assert.assertEquals(4, levelController.getLevelNum());
    }

    @Test
    public void testLevelScore() {
        levelController.setLevelNum(4);
        levelController.initRegularLevel(false);

        Assert.assertEquals(0,  headerModel.getGlobalScore().getScore());
        Assert.assertEquals(2, levelModel.getIce().size());

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(1, headerModel.getGlobalScore().getScore());
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        Assert.assertEquals(levelModel.getIce().size(), 1);
        Assert.assertTrue(levelElementController.getMeltStrategy() instanceof MeltIce);
        Assert.assertEquals(11, headerModel.getGlobalScore().getScore());

        Position hold = levelModel.getPuffle().getPosition();
        levelController.processCommand(KeyHandler.KEY.LEFT);
        levelController.processCommand(KeyHandler.KEY.LEFT);
        levelController.processCommand(KeyHandler.KEY.UP);
        levelController.processCommand(KeyHandler.KEY.DOWN);

        Assert.assertEquals(hold, levelModel.getPuffle().getPosition());
        Assert.assertEquals(11, headerModel.getGlobalScore().getScore());

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(0, levelModel.getCoins().size());

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        Assert.assertEquals(5, levelController.getLevelNum());
    }

    @Test
    public void testLevelKeyLock() {
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

        Assert.assertTrue(levelElementController.getMeltStrategy() instanceof MeltIce);
        Assert.assertNull(levelModel.getLock());
        Assert.assertNull(levelModel.getKey());

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        Assert.assertEquals(6, levelController.getLevelNum());
    }

    @Test
    public void puffleBoxInteract() {
        levelController.setLevelNum(6);
        levelController.initRegularLevel(false);

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(3, levelModel.getIce().size());
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        Assert.assertTrue(levelModel.getBox().getInteraction() instanceof InteractStop);
        levelController.processCommand(KeyHandler.KEY.UP);
        Assert.assertTrue(levelModel.getBox().getInteraction() instanceof InteractBox);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.LEFT);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        Assert.assertEquals(7, levelController.getLevelNum());
    }

    @Test
    public void levelIceMelt() {
        levelController.setLevelNum(7);
        levelController.initRegularLevel(false);

        Assert.assertTrue(levelElementController.getMeltStrategy() instanceof MeltIce);
        Assert.assertEquals(3, levelModel.getDoubleIce().size());
        Assert.assertEquals(1, levelModel.getIce().size());

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertTrue(levelElementController.getMeltStrategy() instanceof MeltDoubleIce);
        Assert.assertEquals(3, levelModel.getDoubleIce().size());
        Assert.assertEquals(1, levelModel.getIce().size());

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertTrue(levelElementController.getMeltStrategy() instanceof MeltDoubleIce);
        Assert.assertEquals(2, levelModel.getDoubleIce().size());
        Assert.assertEquals(2, levelModel.getIce().size());

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertTrue(levelElementController.getMeltStrategy() instanceof MeltDoubleIce);
        Assert.assertEquals(1, levelModel.getDoubleIce().size());
        Assert.assertEquals(3, levelModel.getIce().size());

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertTrue(levelElementController.getMeltStrategy() instanceof MeltIce);
        Assert.assertEquals(0, levelModel.getDoubleIce().size());
        Assert.assertEquals(4, levelModel.getIce().size());

        levelController.processCommand(KeyHandler.KEY.LEFT);

        Assert.assertTrue(levelElementController.getMeltStrategy() instanceof MeltIce);
        Assert.assertEquals(0, levelModel.getDoubleIce().size());
        Assert.assertEquals(3, levelModel.getIce().size());

        levelController.processCommand(KeyHandler.KEY.LEFT);

        Assert.assertTrue(levelElementController.getMeltStrategy() instanceof MeltIce);
        Assert.assertEquals(0, levelModel.getDoubleIce().size());
        Assert.assertEquals(2, levelModel.getIce().size());

        Position hold = levelModel.getPuffle().getPosition();
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        Assert.assertEquals(hold, levelModel.getPuffle().getPosition());

        levelController.processCommand(KeyHandler.KEY.LEFT);

        Assert.assertTrue(levelElementController.getMeltStrategy() instanceof MeltIce);
        Assert.assertEquals(0, levelModel.getDoubleIce().size());
        Assert.assertEquals(1, levelModel.getIce().size());

        levelController.processCommand(KeyHandler.KEY.DOWN);
        Assert.assertEquals(8, levelController.getLevelNum());
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
        Assert.assertTrue(levelElementController.getMeltStrategy() instanceof MeltNothing);
        levelController.processCommand(KeyHandler.KEY.UP);
        Assert.assertTrue(levelElementController.getMeltStrategy() instanceof MeltIce);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.LEFT);
        Assert.assertTrue(levelElementController.getMeltStrategy() instanceof MeltNothing);

        Assert.assertEquals(0, levelModel.getIce().size());

        levelController.processCommand(KeyHandler.KEY.DOWN);
        Assert.assertEquals(9, levelController.getLevelNum());
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

        Assert.assertEquals(1, levelModel.getIce().size());

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(1, levelModel.getIce().size());

        levelController.processCommand(KeyHandler.KEY.DOWN);
        Assert.assertEquals(10, levelController.getLevelNum());
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
        Assert.assertTrue(levelController.processCommand(KeyHandler.KEY.NEXT));
        Assert.assertTrue(levelController.processCommand(KeyHandler.KEY.RESTART));
        Assert.assertFalse(levelController.processCommand(KeyHandler.KEY.CLOSE));
        Assert.assertTrue(levelController.processCommand(KeyHandler.KEY.UP));
        Assert.assertTrue(levelController.processCommand(KeyHandler.KEY.DOWN));
        Assert.assertTrue(levelController.processCommand(KeyHandler.KEY.LEFT));
        Assert.assertTrue(levelController.processCommand(KeyHandler.KEY.RIGHT));
    }
}
