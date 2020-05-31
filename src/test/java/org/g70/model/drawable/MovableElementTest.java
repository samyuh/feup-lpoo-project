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

        Assert.assertEquals(new Position(1, 1), boxTest.getPosition());
        Assert.assertEquals(new Position(1, 1), puffleTest.getPosition());

        Assert.assertEquals(new Position(2, 1), puffleTest.moveRight());
        Assert.assertEquals(1, puffleTest.lastDisplacementX());
        Assert.assertEquals(0, puffleTest.lastDisplacementY());

        Assert.assertEquals(new Position(1, 2), puffleTest.moveDown());
        Assert.assertEquals(0, puffleTest.lastDisplacementX());
        Assert.assertEquals(1, puffleTest.lastDisplacementY());

        Assert.assertEquals(new Position(0, 1), puffleTest.moveLeft());
        Assert.assertEquals(-1, puffleTest.lastDisplacementX());
        Assert.assertEquals(0, puffleTest.lastDisplacementY());

        Assert.assertEquals(new Position(1, 0), puffleTest.moveUp());
        Assert.assertEquals(0, puffleTest.lastDisplacementX());
        Assert.assertEquals(-1, puffleTest.lastDisplacementY());

        Assert.assertEquals(new Position(5, 7), puffleTest.moveDisplacement(4, 6));
        Assert.assertEquals(new Position(-9, 7), puffleTest.moveDisplacement(-10, 6));
        Assert.assertEquals(new Position(-9, -5), puffleTest.moveDisplacement(-10, -6));
        Assert.assertEquals(new Position(1, 0), puffleTest.moveDisplacement(0, -1));
        Assert.assertEquals(new Position(1, 1), puffleTest.moveDisplacement(0, 0));
    }
}
