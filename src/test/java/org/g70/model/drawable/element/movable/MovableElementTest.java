package org.g70.model.drawable.element.movable;

import org.g70.model.Position;
import org.g70.model.drawable.element.Box;
import org.junit.*;
import org.junit.Test;


public class MovableElementTest {
    @Test
    public void movementTest() {
        org.g70.model.drawable.element.Puffle puffle = new org.g70.model.drawable.element.Puffle(new Position(1, 1));
        Box box = new Box(new Position(1, 1));

        Box boxTest1 = new Box(box);
        Puffle puffleTest1 = new Puffle(puffle);

        Assert.assertEquals(boxTest1.getPosition(), new Position(1, 1));
        Assert.assertEquals(puffleTest1.getPosition(), new Position(1, 1));

        Assert.assertEquals(puffleTest1.moveRight(), new Position(2, 1));
        Assert.assertEquals(puffleTest1.lastDisplacementX(), 1);
        Assert.assertEquals(puffleTest1.lastDisplacementY(), 0);

        Assert.assertEquals(puffleTest1.moveDown(), new Position(1, 2));
        Assert.assertEquals(puffleTest1.lastDisplacementX(), 0);
        Assert.assertEquals(puffleTest1.lastDisplacementY(), 1);

        Assert.assertEquals(puffleTest1.moveLeft(), new Position(0, 1));
        Assert.assertEquals(puffleTest1.lastDisplacementX(), -1);
        Assert.assertEquals(puffleTest1.lastDisplacementY(), 0);

        Assert.assertEquals(puffleTest1.moveUp(), new Position(1, 0));
        Assert.assertEquals(puffleTest1.lastDisplacementX(), 0);
        Assert.assertEquals(puffleTest1.lastDisplacementY(), -1);

        Assert.assertEquals(puffleTest1.moveDisplacement(4, 6), new Position(5, 7));
        Assert.assertEquals(puffleTest1.moveDisplacement(-10, 6), new Position(-9, 7));
        Assert.assertEquals(puffleTest1.moveDisplacement(-10, -6), new Position(-9, -5));
        Assert.assertEquals(puffleTest1.moveDisplacement(0, -1), new Position(1, 0));
        Assert.assertEquals(puffleTest1.moveDisplacement(0, 0), new Position(1, 1));
    }
}
