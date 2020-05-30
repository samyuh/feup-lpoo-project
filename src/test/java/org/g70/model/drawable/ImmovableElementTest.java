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
        assertEquals(element.getPosition().getX(), 1);
        assertEquals(element.getPosition().getY(), 2);
        assertEquals(element.getImage(), "D");
        assertEquals(element.getColorForeground(), "#ff0422");
        assertTrue(element.getInteraction() instanceof InteractFinish);
    }

    @Test
    public void elementCoin() {
        Coin element = new Coin(new Position(1, 2));

        Assert.assertTrue(element.getInteraction() instanceof InteractCoin);
        assertEquals(element.getPosition().getX(), 1);
        assertEquals(element.getPosition().getY(), 2);
        assertEquals(element.getImage(), "$");
        assertEquals(element.getColorForeground(), "#FFFF33");
    }

    @Test
    public void elementInvisibleWall() {
        InvisibleWall element = new InvisibleWall(new Position(1, 2));

        Assert.assertTrue(element.getInteraction() instanceof InteractInvisibleWall);
        assertEquals(element.getPosition().getX(), 1);
        assertEquals(element.getPosition().getY(), 2);
        assertEquals(element.getImage(), "\u2588");
        assertEquals(element.getColorForeground(), "#0065c6");
    }
}
