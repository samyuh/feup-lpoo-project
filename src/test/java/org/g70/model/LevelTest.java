package org.g70.model;

import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.element.Coin;
import org.g70.model.drawable.element.ElementModel;
import org.g70.model.drawable.element.DoubleIce;
import org.g70.model.level.LevelModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class LevelTest {
    LevelModel testM;
    private List<ElementModel> elements;
    private List<Position> positions;
    private Position pCoin1;
    private Position pFrozenIce1;

    @Before
    public void startLevel() {
        this.testM = new LevelModel();
        this.elements = new ArrayList<>();
        this.positions = new ArrayList<>();

        Position pCoin1 = Mockito.mock(Position.class);
        Mockito.when(pCoin1.getX()).thenReturn(0);
        Mockito.when(pCoin1.getY()).thenReturn(0);

        Coin w1 = Mockito.mock(Coin.class);
        Mockito.when(w1.getPosition()).thenReturn(pCoin1);

        List<Coin> coin = new ArrayList<>();
        coin.add(w1);
        testM.setCoins(coin);
        this.elements.add(w1);
        this.positions.add(pCoin1);

        this.pFrozenIce1 = Mockito.mock(Position.class);
        Mockito.when(pFrozenIce1.getX()).thenReturn(1);
        Mockito.when(pFrozenIce1.getY()).thenReturn(1);

        DoubleIce i1 = Mockito.mock(DoubleIce.class);
        Mockito.when(i1.getPosition()).thenReturn(pFrozenIce1);

        List<DoubleIce> doubleIce = new ArrayList<>();
        doubleIce.add(i1);
        testM.setDoubleIce(doubleIce);
        this.elements.add(i1);
        this.positions.add(pFrozenIce1);

        // Set other things
    }

    @Test
    public void levelTest() {
        List<Drawable> m = testM.getAll();
        Assert.assertEquals(m.size(), elements.size() + 4);

        ElementModel e0 = testM.find(positions.get(0));
        Assert.assertEquals(e0, elements.get(0));

        testM.clearLevel(true);
        Assert.assertEquals(testM.getDoubleIce().isEmpty(), true);
    }
}
