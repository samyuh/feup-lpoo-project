package org.g70.model;

import org.g70.model.drawable.element.immovable.Coin;
import org.g70.model.drawable.element.ElementModel;
import org.g70.model.drawable.element.immovable.DoubleIce;
import org.g70.model.level.LevelModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class LevelTest {
    private LevelModel testM;
    private List<ElementModel> elements;
    private List<Position> positions;
    private Position pFrozenIce1;

    @Before
    public void startLevel() {
        testM = new LevelModel();
        elements = new ArrayList<>();
        positions = new ArrayList<>();

        Position pCoin1 = Mockito.mock(Position.class);
        Mockito.when(pCoin1.getX()).thenReturn(0);
        Mockito.when(pCoin1.getY()).thenReturn(0);

        Coin w1 = Mockito.mock(Coin.class);
        Mockito.when(w1.getPosition()).thenReturn(pCoin1);

        testM.addCoins(w1);
        elements.add(w1);
        positions.add(pCoin1);

        pFrozenIce1 = Mockito.mock(Position.class);
        Mockito.when(pFrozenIce1.getX()).thenReturn(1);
        Mockito.when(pFrozenIce1.getY()).thenReturn(1);

        DoubleIce i1 = Mockito.mock(DoubleIce.class);
        Mockito.when(i1.getPosition()).thenReturn(pFrozenIce1);

        testM.addDoubleIce(i1);
        elements.add(i1);
        positions.add(pFrozenIce1);

        // Set other things
    }

    @Test
    public void levelTest() {
        /*
        List<Drawable> m = testM.getAll();
        Assert.assertEquals(m.size(), elements.size() + 4);

        ElementModel e0 = testM.find(positions.get(0));
        Assert.assertEquals(e0, elements.get(0));

        testM.clearLevel(true);
        Assert.assertEquals(testM.getDoubleIce().isEmpty(), true);

         */
    }
}
