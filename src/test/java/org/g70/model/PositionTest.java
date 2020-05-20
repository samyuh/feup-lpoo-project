package org.g70.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {
    @Test
    public void positionTest() {
        Position elementPos1 = new Position(0,1);
        Position elementPos2 = new Position(0,1);

        assertEquals(elementPos1.getX(), elementPos2.getX());

    }
}