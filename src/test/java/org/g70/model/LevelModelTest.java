package org.g70.model;

import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.element.immovable.Coin;
import org.g70.model.drawable.element.ElementModel;
import org.g70.model.drawable.element.immovable.DoubleIce;
import org.g70.model.level.LevelModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LevelModelTest {
    private LevelModel testM;
    private List<ElementModel> elements;

    @Before
    public void startLevel() {
        testM = new LevelModel();
        elements = new ArrayList<>();

        Position position = new Position(0, 0);

        Coin e1 = new Coin(position);
        DoubleIce e2 = new DoubleIce(position);

        testM.addCoins(e1);
        testM.addDoubleIce(e2);

        elements.add(e1);
        elements.add(e2);
    }

    @Test
    public void levelTest() {
        List<Drawable> drawables = testM.getAll();
        Assert.assertEquals(drawables.size(), elements.size());

        testM.clearLevel(true);
        Assert.assertEquals(testM.getDoubleIce().isEmpty(), false);

        testM.clearLevel(false);
        Assert.assertEquals(testM.getDoubleIce().isEmpty(), true);
    }
}
