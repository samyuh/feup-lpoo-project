package controller;

import controller.element.PuffleMovement;
import controller.level.LevelController;
import controller.level.LevelInitializer;
import model.Position;
import model.level.LevelModel;
import org.junit.Test;
import org.mockito.Mockito;
import view.handler.KeyHandler;
import view.level.LevelView;

import java.io.IOException;

import static org.junit.Assert.*;

public class LevelTest {
    @Test
    public void initLevelTest() {
        LevelModel levelModel = new LevelModel();
        LevelInitializer levelInit = new LevelInitializer(levelModel);

        levelInit.initLevel(1);

        assertEquals(levelModel.getWalls().size(), 24);
        assertEquals(levelModel.getCoins().size(), 0);
        assertEquals(levelModel.getToughIce().size(), 0);

        // Finish with all levelModel to ensure that is reading
    }
    @Test
    public void levelControllerTest() throws IOException {
        LevelView levelView = Mockito.mock(LevelView.class);
        LevelModel levelModel = new LevelModel();

        LevelController levelC = new LevelController(levelModel, levelView);

        // Win First Level Test
        PuffleMovement heroMTest1 = levelC.getPuffleMovement();
        assertEquals(levelC.getlevelNum(),1);

        Position start1 = new Position(1, 1);
        Position intermediate1 = new Position(3, 1);
        Position finish1 = new Position(9, 1);

        assertTrue(heroMTest1.atPosition(start1));
        levelC.processCommand(KeyHandler.DIRECTION.UP);
        assertTrue(heroMTest1.atPosition(start1));

        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);

        assertFalse(levelC.gameWon());
        assertFalse(levelC.gameLost());

        assertTrue(heroMTest1.atPosition(intermediate1));
        levelC.processCommand(KeyHandler.DIRECTION.LEFT);
        assertTrue(heroMTest1.atPosition(intermediate1));
        levelC.processCommand(KeyHandler.DIRECTION.UP);
        assertTrue(heroMTest1.atPosition(intermediate1));
        levelC.processCommand(KeyHandler.DIRECTION.DOWN);
        assertTrue(heroMTest1.atPosition(intermediate1));

        assertFalse(levelC.gameWon());
        assertFalse(levelC.gameLost());

        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        assertTrue(heroMTest1.atPosition(finish1));
        levelC.processCommand(KeyHandler.DIRECTION.RIGHT);
        assertTrue(heroMTest1.atPosition(finish1));

        assertTrue(levelC.gameWon());
        assertFalse(levelC.gameLost());

        // Lose Level 3 Test
        /*
        levelC.setLevel();
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