package org.g70.controller;

import org.g70.controller.level.LevelBuilder;
import org.g70.controller.level.LevelController;
import org.g70.controller.level.movement.PuffleMovement;
import org.g70.model.Position;
import org.g70.model.level.LevelModel;
import org.junit.Test;
import org.mockito.Mockito;
import org.g70.view.handler.KeyHandler;
import org.g70.view.level.LevelView;

import java.io.IOException;

import static org.junit.Assert.*;

public class LevelControllerTest {
    @Test
    public void initLevelTest() {
        LevelModel levelModel = new LevelModel();
        LevelBuilder levelInit = new LevelBuilder(levelModel);

        levelInit.initLevel(1);

        assertEquals(levelModel.getWalls().size(), 24);
        assertEquals(levelModel.getCoins().size(), 0);
        assertEquals(levelModel.getToughIce().size(), 0);

        // Finish with all levelModel to ensure that is reading

    }

    @Test
    public void levelControllerTest() throws IOException {
        /*
        LevelView levelView = Mockito.mock(LevelView.class);
        LevelModel levelModel = new LevelModel();

        LevelController levelC = new LevelController(levelModel, levelView);

        // Win First Level Test
        PuffleMovement heroMTest1 = levelC.getPuffleMovement();
        assertEquals(levelC.getlevelNum(),1);

        Position start1 = levelModel.getPuffle().getPosition();
        Position finish1 = levelModel.getDestination().getPosition();

        assertTrue(heroMTest1.atPosition(start1));
        levelC.processCommand(KeyHandler.DIRECTION.UP);
        assertTrue(heroMTest1.atPosition(start1));

        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);

        assertFalse(levelC.gameWon());
        assertFalse(levelC.gameLost());

        levelC.processCommand(KeyHandler.DIRECTION.LEFT);
        levelC.processCommand(KeyHandler.DIRECTION.UP);
        levelC.processCommand(KeyHandler.DIRECTION.DOWN);

        assertFalse(levelC.gameWon());
        assertFalse(levelC.gameLost());

        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        assertTrue(heroMTest1.atPosition(finish1));

        assertTrue(levelC.gameWon());
        assertFalse(levelC.gameLost());

        // Lose Level 3 Test
        levelC.setLevel(3);
        assertEquals(levelC.getlevelNum(),3);

        PuffleMovement heroMTest2 = levelC.getPuffleMovement();

        Position start2 = new Position(12, 1);
        Position finish2 = new Position(12, 5);

        assertTrue(heroMTest2.atPosition(start2));
        levelC.processCommand(KeyHandler.DIRECTION.DOWN);
        levelC.processCommand(KeyHandler.DIRECTION.DOWN);
        levelC.processCommand(KeyHandler.DIRECTION.DOWN);
        levelC.processCommand(KeyHandler.DIRECTION.LEFT);
        levelC.processCommand(KeyHandler.DIRECTION.DOWN);
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        assertTrue(heroMTest2.atPosition(finish2));

        assertFalse(levelC.gameWon());
        assertTrue(levelC.gameLost());

 */
    }
}
