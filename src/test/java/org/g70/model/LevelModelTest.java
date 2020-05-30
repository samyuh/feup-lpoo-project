package org.g70.model;

import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.element.movable.*;
import org.g70.model.drawable.element.immovable.*;
import org.g70.model.drawable.element.ElementModel;
import org.g70.model.level.LevelModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
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
        EmptyBlock e3 = new EmptyBlock(position);
        Finish e4 = new Finish(position);
        Ice e5 = new Ice(position);
        InvisibleWall e6 = new InvisibleWall(position);
        Key e7 = new Key(position);
        Lock e8 = new Lock(position);
        Secret e9 = new Secret(position);
        Teleport e10 = new Teleport(position);
        Wall e11 = new Wall(position);
        Puffle e12 = new Puffle(position);
        Box e13 = new Box(position);
        Water e14 = new Water(position);

        testM.addCoins(e1);
        testM.addDoubleIce(e2);
        testM.setEmptyBlock(e3);
        testM.setFinish(e4);
        testM.addIce(e5);
        testM.addInvisibleWalls(e6);
        testM.setKey(e7);
        testM.setLock(e8);
        testM.setSecret(e9);
        testM.addTeleports(e10);
        testM.addWalls(e11);
        testM.setPuffle(e12);
        testM.setBox(e13);
        testM.addWater(e14);

        // List of elements(as Drawables) ordered by gamePlay processing data order
        elements.add(e12);
        elements.add(e13);
        elements.add(e8);
        elements.add(e7);
        elements.add(e3);
        elements.add(e9);
        elements.add(e10);
        elements.add(e11);
        elements.add(e6);
        elements.add(e4);
        elements.add(e1);
        elements.add(e2);
        elements.add(e14);
        elements.add(e5);
    }

    @Test
    public void levelTest() {
        List<Drawable> drawables = testM.getAll();

        Assert.assertNotEquals(drawables.get(0), elements.get(0));
        Collections.reverse(elements);
        Assert.assertEquals(drawables.get(0), elements.get(0));
        Assert.assertEquals(drawables.size(), elements.size());

        testM.clearLevel(true);
        Assert.assertTrue(testM.getInvisibleWalls().isEmpty());
        Assert.assertTrue(testM.getWalls().isEmpty());
        Assert.assertFalse(testM.getWater().isEmpty());
        Assert.assertFalse(testM.getCoins().isEmpty());
        Assert.assertFalse(testM.getDoubleIce().isEmpty());
        Assert.assertFalse(testM.getIce().isEmpty());
        Assert.assertFalse(testM.getTeleports().isEmpty());
        Assert.assertNotNull(testM.getFinish());
        Assert.assertNotNull(testM.getKey());
        Assert.assertNotNull(testM.getLock());
        Assert.assertNotNull(testM.getSecret());
        Assert.assertNotNull(testM.getEmptyBlock());
        Assert.assertNotNull(testM.getBox());
        Assert.assertNotNull(testM.getPuffle());

        testM.clearLevel(false);
        Assert.assertTrue(testM.getDoubleIce().isEmpty());
        Assert.assertTrue(testM.getInvisibleWalls().isEmpty());
        Assert.assertTrue(testM.getWalls().isEmpty());
        Assert.assertTrue(testM.getWater().isEmpty());
        Assert.assertTrue(testM.getCoins().isEmpty());
        Assert.assertTrue(testM.getDoubleIce().isEmpty());
        Assert.assertTrue(testM.getIce().isEmpty());
        Assert.assertTrue(testM.getTeleports().isEmpty());
        Assert.assertNull(testM.getFinish());
        Assert.assertNull(testM.getKey());
        Assert.assertNull(testM.getLock());
        Assert.assertNull(testM.getSecret());
        Assert.assertNull(testM.getEmptyBlock());
        Assert.assertNull(testM.getBox());
        Assert.assertNull(testM.getPuffle());
    }
}
