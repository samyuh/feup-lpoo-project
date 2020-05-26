package org.g70.controller.movement;

import org.g70.controller.level.movement.BoxMovement;
import org.g70.controller.level.movement.PuffleMovement;
import org.g70.model.Position;
import org.g70.model.drawable.element.Box;
import org.g70.model.drawable.element.Puffle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovementTest {
    @Test
    public void movementTest() {
        Puffle puffle = new Puffle(new Position(1, 1));
        Box box = new Box(new Position(1, 1));

        BoxMovement boxTest1 = new BoxMovement(box);
        PuffleMovement puffleTest1 = new PuffleMovement(puffle);

        assertEquals(boxTest1.getPosition(), new Position(1, 1));
        assertEquals(puffleTest1.getPosition(), new Position(1, 1));

        assertEquals(puffleTest1.moveRight(), new Position(2, 1));
        assertEquals(puffleTest1.lastDisplacementX(), 1);
        assertEquals(puffleTest1.lastDisplacementY(), 0);

        assertEquals(puffleTest1.moveDown(), new Position(1, 2));
        assertEquals(puffleTest1.lastDisplacementX(), 0);
        assertEquals(puffleTest1.lastDisplacementY(), 1);

        assertEquals(puffleTest1.moveLeft(), new Position(0, 1));
        assertEquals(puffleTest1.lastDisplacementX(), -1);
        assertEquals(puffleTest1.lastDisplacementY(), 0);

        assertEquals(puffleTest1.moveUp(), new Position(1, 0));
        assertEquals(puffleTest1.lastDisplacementX(), 0);
        assertEquals(puffleTest1.lastDisplacementY(), -1);

        assertEquals(puffleTest1.moveDisplacement(4, 6), new Position(5, 7));
        assertEquals(puffleTest1.moveDisplacement(-10, 6), new Position(-9, 7));
        assertEquals(puffleTest1.moveDisplacement(-10, -6), new Position(-9, -5));
        assertEquals(puffleTest1.moveDisplacement(0, -1), new Position(1, 0));
        assertEquals(puffleTest1.moveDisplacement(0, 0), new Position(1, 1));
    }
}
