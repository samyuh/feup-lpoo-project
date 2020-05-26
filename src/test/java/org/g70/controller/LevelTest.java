package org.g70.controller;

import org.g70.controller.level.LevelBuilder;
import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.movement.PuffleMovement;
import org.g70.model.Position;
import org.g70.model.level.LevelHeaderModel;
import org.g70.model.level.LevelModel;
import org.g70.view.game.LevelView;
import org.g70.view.handler.KeyHandler;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class LevelTest {
    @Test
    public void levelBuilderTest() {
        LevelModel levelModel = new LevelModel();
        LevelBuilder levelInit = new LevelBuilder(levelModel);

        levelInit.initLevel(1, false);

        assertEquals(levelModel.getWalls().size(), 24);
        assertEquals(levelModel.getCoins().size(), 0);
        assertEquals(levelModel.getDoubleIce().size(), 0);

        // Finish with all levelModel to ensure that is reading
    }

    @Test
    public void levelWinLoseTest() {
        // Not necessary
        LevelView levelView = Mockito.mock(LevelView.class);
        LevelModel levelModel = new LevelModel();
        LevelHeaderModel headerModel = new LevelHeaderModel(1);

        LevelController levelC = new LevelController(levelModel, headerModel, levelView);

        // Win First Level Test
        LevelFacade levelFacade = levelC.getLevelFacade();
        PuffleMovement puffleTest1 = levelFacade.getPuffleMovement();

        Position start1 = levelModel.getPuffle().getPosition();
        Position finish1 = levelModel.getFinish().getPosition();

        assertEquals(puffleTest1.getPosition(), start1);

        levelC.processCommand(KeyHandler.KEY.UP);
        assertEquals(puffleTest1.getPosition(), start1);

        levelC.processCommand(KeyHandler.KEY.RIGHT);
        levelC.processCommand(KeyHandler.KEY.RIGHT);

        assertFalse(levelC.gameFinished());
        assertEquals(levelC.getLevelNum(), 1);

        levelC.processCommand(KeyHandler.KEY.LEFT);
        levelC.processCommand(KeyHandler.KEY.UP);
        levelC.processCommand(KeyHandler.KEY.DOWN);

        assertFalse(levelC.gameFinished());
        assertEquals(levelC.getLevelNum(), 1);

        levelC.processCommand(KeyHandler.KEY.RIGHT);
        levelC.processCommand(KeyHandler.KEY.RIGHT);
        levelC.processCommand(KeyHandler.KEY.RIGHT);
        levelC.processCommand(KeyHandler.KEY.RIGHT);
        levelC.processCommand(KeyHandler.KEY.RIGHT);
        levelC.processCommand(KeyHandler.KEY.RIGHT);
        assertEquals(puffleTest1.getPosition(), finish1);

        assertFalse(levelC.gameFinished());

        // Lose Level
        assertEquals(levelC.getLevelNum(), 2);
        PuffleMovement puffleTest2 = levelFacade.getPuffleMovement();

        Position start2 = new Position(14, 3);
        Position finish2 = new Position(14, 7);

        assertEquals(puffleTest2.getPosition(), start2);
        levelC.processCommand(KeyHandler.KEY.DOWN);
        levelC.processCommand(KeyHandler.KEY.DOWN);
        levelC.processCommand(KeyHandler.KEY.DOWN);
        levelC.processCommand(KeyHandler.KEY.LEFT);
        levelC.processCommand(KeyHandler.KEY.DOWN);
        levelC.processCommand(KeyHandler.KEY.RIGHT);
        assertEquals(puffleTest2.getPosition(), finish2);

        assertTrue(levelC.gameFinished());
    }

    @Test
    public void levelControllerLoopTest() {
        // To Do
    }

    @Test
    public void levelFacadeTest() {
        // To Do
    }

    @Test
    public void levelInteractTest() {
        // To Do
    }
}
