package org.g70.controller.level;

import org.g70.controller.level.movement.PuffleMovement;
import org.g70.model.Position;
import org.g70.model.drawable.element.Secret;
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
    public void levelBuilderTest() {
        LevelBuilder levelInit = new LevelBuilder(levelModel);

        levelInit.initLevel(1, false);
        Assert.assertEquals(levelModel.getWalls().size(), 24);
        Assert.assertEquals(levelModel.getCoins().size(), 0);
        Assert.assertEquals(levelModel.getDoubleIce().size(), 0);

        // Finish with all levelModel to ensure that is reading
        levelInit.initLevel(2, false);
        levelInit.initLevel(3, false);
        levelInit.initLevel(3, true);
        levelInit.initLevel(4, false);
        levelInit.initLevel(5, false);
        levelInit.initLevel(6, false);
    }

    @Test
    public void levelWinTest() {
        PuffleMovement puffleTest = levelFacade.getPuffleMovement();
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
    public void levelWinLoseTest() {
        levelController.processCommand(KeyHandler.KEY.NEXT);

        Assert.assertEquals(levelController.getLevelNum(), 2);
        PuffleMovement puffleTest = levelFacade.getPuffleMovement();


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
    public void levelCoinTest() {
        levelController.setLevelNum(4);
        levelController.initRegularLevel(false);

        int previousScore = headerModel.getGlobalScore().getScore();

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        int afterCoinScore = headerModel.getGlobalScore().getScore();

        Assert.assertEquals(previousScore + 10, afterCoinScore);

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        Assert.assertEquals(levelModel.getIce().size(), 1);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        Assert.assertEquals(levelController.getLevelNum(), 5);
    }

    @Test
    public void testLevelKey() {
        levelController.setLevelNum(5);
        levelController.initRegularLevel(false);

        PuffleMovement puffleTest = levelFacade.getPuffleMovement();

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Position previousDoor = puffleTest.getPosition();

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(puffleTest.getPosition(),
                previousDoor);

        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.UP);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(levelModel.getIce().size(), 1);

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(levelController.getLevelNum(), 6);
    }

    @Test
    public void testLevelBox() {
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
    public void testLevelIceMelt() {
        levelController.setLevelNum(7);
        levelController.initRegularLevel(false);

        Assert.assertEquals(levelModel.getDoubleIce().size(), 3);
        Assert.assertEquals(levelModel.getIce().size(), 1);

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(levelModel.getDoubleIce().size(), 3);
        Assert.assertEquals(levelModel.getIce().size(), 1);

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(levelModel.getDoubleIce().size(), 2);
        Assert.assertEquals(levelModel.getIce().size(), 2);

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(levelModel.getDoubleIce().size(), 1);
        Assert.assertEquals(levelModel.getIce().size(), 3);

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(levelModel.getDoubleIce().size(), 0);
        Assert.assertEquals(levelModel.getIce().size(), 4);

        levelController.processCommand(KeyHandler.KEY.LEFT);

        Assert.assertEquals(levelModel.getDoubleIce().size(), 0);
        Assert.assertEquals(levelModel.getIce().size(), 3);

        levelController.processCommand(KeyHandler.KEY.LEFT);

        Assert.assertEquals(levelModel.getDoubleIce().size(), 0);
        Assert.assertEquals(levelModel.getIce().size(), 2);

        levelController.processCommand(KeyHandler.KEY.LEFT);

        Assert.assertEquals(levelModel.getDoubleIce().size(), 0);
        Assert.assertEquals(levelModel.getIce().size(), 1);

        levelController.processCommand(KeyHandler.KEY.DOWN);

        Assert.assertEquals(levelController.getLevelNum(), 8);
    }

    @Test
    public void testEmptyBlockTest() {
        levelController.setLevelNum(8);
        levelController.initRegularLevel(false);

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.UP);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.DOWN);
        levelController.processCommand(KeyHandler.KEY.LEFT);

        Assert.assertEquals(levelModel.getIce().size(), 0);

        levelController.processCommand(KeyHandler.KEY.DOWN);

        Assert.assertEquals(levelController.getLevelNum(), 9);
    }

    @Test
    public void testTeleportBoxWinTest() {
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
    public void testTeleportBoxLoseTest() {
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
    public void levelAllElementsTest() {
        levelController.setLevelNum(3);
        levelController.initRegularLevel(false);

        // -- Test Teleport -- //
        Position initialPufflePosition = levelModel.getPuffle().getPosition();

        PuffleMovement puffleTest = levelFacade.getPuffleMovement();

        Position teleportOne = new Position(12, 9);
        Position teleportTwo = new Position(9, 13);

        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);
        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(puffleTest.getPosition().getX(), teleportOne.getX() - 1);
        Assert.assertEquals(puffleTest.getPosition().getY(), teleportOne.getY());

        levelController.processCommand(KeyHandler.KEY.RIGHT);

        Assert.assertEquals(puffleTest.getPosition(), teleportTwo);

        // -- Test Restart -- //
        levelController.processCommand(KeyHandler.KEY.RESTART);
        puffleTest = levelFacade.getPuffleMovement();

        Assert.assertEquals(puffleTest.getPosition(), initialPufflePosition);

        // -- Test Secret -- //
        Position previousSecret = new Position(19, 14);
        levelModel.getPuffle().setPosition(previousSecret);
        Secret secret = levelModel.getSecret();

        levelController.processCommand(KeyHandler.KEY.DOWN);
        Assert.assertEquals(puffleTest.getPosition(), secret.getPosition());
        Assert.assertNull(levelModel.getSecret());

        // -- Test Secret Restart -- //
        levelController.processCommand(KeyHandler.KEY.RESTART);

        puffleTest = levelFacade.getPuffleMovement();
        Assert.assertEquals(puffleTest.getPosition(), initialPufflePosition);
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

    @Test
    public void levelFacadeTest() {
        // To Do
    }
}
