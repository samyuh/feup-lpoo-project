package org.g70.model.drawable;

import org.g70.controller.level.interact.InteractBox;
import org.g70.controller.level.interact.InteractStop;
import org.g70.model.Position;
import org.g70.model.drawable.element.movable.*;
import org.junit.*;
import org.junit.Test;


public class MovableElementTest {
    @Test
    public void movementTest() {
        Puffle puffleTest = new Puffle(new Position(1, 1));
        Box boxTest = new Box(new Position(1, 1));

        Assert.assertTrue(boxTest.getInteraction() instanceof InteractBox);
        Assert.assertTrue(puffleTest.getInteraction() instanceof InteractStop);

        Assert.assertEquals(boxTest.getPosition(), new Position(1, 1));
        Assert.assertEquals(puffleTest.getPosition(), new Position(1, 1));

        Assert.assertEquals(puffleTest.moveRight(), new Position(2, 1));
        Assert.assertEquals(puffleTest.lastDisplacementX(), 1);
        Assert.assertEquals(puffleTest.lastDisplacementY(), 0);

        Assert.assertEquals(puffleTest.moveDown(), new Position(1, 2));
        Assert.assertEquals(puffleTest.lastDisplacementX(), 0);
        Assert.assertEquals(puffleTest.lastDisplacementY(), 1);

        Assert.assertEquals(puffleTest.moveLeft(), new Position(0, 1));
        Assert.assertEquals(puffleTest.lastDisplacementX(), -1);
        Assert.assertEquals(puffleTest.lastDisplacementY(), 0);

        Assert.assertEquals(puffleTest.moveUp(), new Position(1, 0));
        Assert.assertEquals(puffleTest.lastDisplacementX(), 0);
        Assert.assertEquals(puffleTest.lastDisplacementY(), -1);

        Assert.assertEquals(puffleTest.moveDisplacement(4, 6), new Position(5, 7));
        Assert.assertEquals(puffleTest.moveDisplacement(-10, 6), new Position(-9, 7));
        Assert.assertEquals(puffleTest.moveDisplacement(-10, -6), new Position(-9, -5));
        Assert.assertEquals(puffleTest.moveDisplacement(0, -1), new Position(1, 0));
        Assert.assertEquals(puffleTest.moveDisplacement(0, 0), new Position(1, 1));
    }
}
