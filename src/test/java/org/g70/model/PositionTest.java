package org.g70.model;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {
    @Test
    public void positionTest() {
        Position elementPos1 = new Position(0,1);
        Position elementPos2 = new Position(0,1);

        Assert.assertEquals(elementPos1.getX(), elementPos2.getX());
        Assert.assertEquals(elementPos1.getY(), elementPos2.getY());
        Assert.assertEquals(elementPos1, elementPos2);
        Assert.assertNotEquals(null, elementPos1);
    }
}