import Model.Game.Level;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void testLevel(){
        Level newLevel = new Level(1);
        assertEquals(1, newLevel.getLevelNumber());
    }
}