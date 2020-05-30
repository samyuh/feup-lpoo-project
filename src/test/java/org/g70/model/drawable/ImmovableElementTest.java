package org.g70.model.drawable;

import org.g70.controller.level.interact.InteractBox;
import org.g70.controller.level.interact.InteractCoin;
import org.g70.controller.level.interact.InteractFinish;
import org.g70.controller.level.interact.InteractInvisibleWall;
import org.g70.model.Position;
import org.g70.model.drawable.element.immovable.Coin;
import org.g70.model.drawable.element.immovable.Finish;
import org.g70.model.drawable.element.immovable.InvisibleWall;
import org.g70.model.drawable.element.movable.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ImmovableElementTest {
    @Test
    public void elementFinish() {
        Finish element = new Finish(new Position(1, 2));

        Assert.assertTrue(element.getInteraction() instanceof InteractFinish);
        assertEquals(1, element.getPosition().getX());
        assertEquals(2, element.getPosition().getY());
        assertEquals("D", element.getImage());
        assertEquals("#ff0422", element.getColorForeground());
        assertTrue(element.getInteraction() instanceof InteractFinish);
    }

    @Test
    public void elementCoin() {
        Coin element = new Coin(new Position(1, 2));

        Assert.assertTrue(element.getInteraction() instanceof InteractCoin);
        assertEquals(1, element.getPosition().getX());
        assertEquals(2, element.getPosition().getY());
        assertEquals("$", element.getImage());
        assertEquals("#FFFF33", element.getColorForeground());
    }

    @Test
    public void elementInvisibleWall() {
        InvisibleWall element = new InvisibleWall(new Position(1, 2));

        assertEquals(1, element.getPosition().getX());
        assertEquals(2, element.getPosition().getY());
        assertEquals("\u2588", element.getImage());
        assertEquals("#0065c6", element.getColorForeground());
        Assert.assertTrue(element.getInteraction() instanceof InteractInvisibleWall);
    }
}
