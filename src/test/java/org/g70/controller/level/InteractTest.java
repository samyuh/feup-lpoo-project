package org.g70.controller.level;

import org.g70.controller.level.interact.*;
import org.g70.controller.level.strategy.MeltDoubleIce;
import org.g70.controller.level.strategy.MeltIce;
import org.g70.controller.level.strategy.MeltNothing;
import org.g70.model.Position;
import org.g70.model.drawable.element.immovable.*;
import org.g70.model.drawable.element.movable.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class InteractTest {
    private LevelController controllerMock;
    private LevelElementController elementControllerMock;
    private Position position;

    @Before
    public void initElements() {
        controllerMock = Mockito.mock(LevelController.class);
        elementControllerMock = Mockito.mock(LevelElementController.class);
        position = new Position(0,0);
    }

    @Test
    public void interactBox() {
        Box testBox = new Box(position);
        InteractBox interactTest = new InteractBox(testBox);

        Assert.assertFalse(interactTest.executeBox(elementControllerMock));
        Mockito.verify(elementControllerMock, Mockito.times(0)).moveBox(position);

        Mockito.when(elementControllerMock.boxLoop()).thenReturn(false);
        interactTest.executePuffle(controllerMock, elementControllerMock);
        Mockito.verify(controllerMock, Mockito.times(0)).executePuffleMovement(position);
        Assert.assertTrue(testBox.getInteraction() instanceof InteractStop);

        testBox = new Box(position);
        interactTest = new InteractBox(testBox);

        Mockito.when(elementControllerMock.boxLoop()).thenReturn(true);
        interactTest.executePuffle(controllerMock, elementControllerMock);
        Mockito.verify(controllerMock, Mockito.times(1)).executePuffleMovement(position);
        Assert.assertTrue(testBox.getInteraction() instanceof InteractBox);
    }

    @Test
    public void interactCoin() {
        Coin testCoin = new Coin(position);
        InteractCoin interactTest = new InteractCoin(testCoin);

        Assert.assertTrue(interactTest.executeBox(elementControllerMock));
        Mockito.verify(elementControllerMock, Mockito.times(1)).moveBox(position);

        interactTest.executePuffle(controllerMock, elementControllerMock);
        Mockito.verify(elementControllerMock, Mockito.times(1)).movePuffle(position);
        Mockito.verify(controllerMock, Mockito.times(1)).addScore(1, 10);

        Mockito.verify(elementControllerMock, Mockito.times(1)).setMelt(Mockito.any(MeltIce.class));
    }

    @Test
    public void interactDoubleIce() {
        DoubleIce testIce = new DoubleIce(position);
        InteractDoubleIce interactTest = new InteractDoubleIce(testIce);

        Assert.assertTrue(interactTest.executeBox(elementControllerMock));
        Mockito.verify(elementControllerMock, Mockito.times(1)).moveBox(position);

        interactTest.executePuffle(controllerMock, elementControllerMock);
        Mockito.verify(elementControllerMock, Mockito.times(1)).movePuffle(position);
        Mockito.verify(controllerMock, Mockito.times(1)).addScore(1, 1);
        Mockito.verify(elementControllerMock, Mockito.times(1)).setMelt(Mockito.any(MeltDoubleIce.class));
    }

    @Test
    public void interactEmptyBlock() {
        EmptyBlock testEmptyBlock = new EmptyBlock(position);
        InteractEmptyBlock interactTest = new InteractEmptyBlock(testEmptyBlock);

        Assert.assertTrue(interactTest.executeBox(elementControllerMock));
        Mockito.verify(elementControllerMock, Mockito.times(1)).moveBox(position);

        interactTest.executePuffle(controllerMock, elementControllerMock);
        Mockito.verify(elementControllerMock, Mockito.times(1)).movePuffle(position);

        Mockito.verify(elementControllerMock, Mockito.times(1)).setMelt(Mockito.any(MeltNothing.class));
    }

    @Test
    public void interactIce() {
        Ice testIce = new Ice(position);
        InteractIce interactTest = new InteractIce(testIce);

        Assert.assertTrue(interactTest.executeBox(elementControllerMock));
        Mockito.verify(elementControllerMock, Mockito.times(1)).moveBox(position);

        interactTest.executePuffle(controllerMock, elementControllerMock);
        Mockito.verify(elementControllerMock, Mockito.times(1)).movePuffle(position);
        Mockito.verify(controllerMock, Mockito.times(1)).addScore(1, 1);

        Mockito.verify(elementControllerMock, Mockito.times(1)).setMelt(Mockito.any(MeltIce.class));
    }

    @Test
    public void interactFinish() {
        Finish testFinish = new Finish(position);
        InteractFinish interactTest = new InteractFinish(testFinish);

        Assert.assertTrue(interactTest.executeBox(elementControllerMock));
        Mockito.verify(elementControllerMock, Mockito.times(1)).moveBox(position);

        interactTest.executePuffle(controllerMock, elementControllerMock);
        Mockito.verify(elementControllerMock, Mockito.times(1)).movePuffle(position);
        Mockito.verify(controllerMock, Mockito.times(1)).addScore(1, 1);

        Mockito.verify(elementControllerMock, Mockito.times(1)).setMelt(Mockito.any(MeltIce.class));
    }

    @Test
    public void interactInvisibleWall() {
        InvisibleWall testInvisibleWall = new InvisibleWall(position);
        InteractInvisibleWall interactTest = new InteractInvisibleWall(testInvisibleWall);

        Assert.assertFalse(interactTest.executeBox(elementControllerMock));
        Mockito.verify(elementControllerMock, Mockito.times(0)).moveBox(position);

        interactTest.executePuffle(controllerMock, elementControllerMock);
        Mockito.verify(elementControllerMock, Mockito.times(1)).movePuffle(position);
        Mockito.verify(controllerMock, Mockito.times(1)).addScore(1, 1);
        Assert.assertTrue(testInvisibleWall.getInteraction() instanceof InteractStop);
        Mockito.verify(elementControllerMock, Mockito.times(1)).setMelt(Mockito.any(MeltNothing.class));
    }

    @Test
    public void interactKey() {
        Key testKey = new Key(position);
        InteractKey interactTest = new InteractKey(testKey);

        Assert.assertTrue(interactTest.executeBox(elementControllerMock));
        Mockito.verify(elementControllerMock, Mockito.times(1)).moveBox(position);

        interactTest.executePuffle(controllerMock, elementControllerMock);
        Mockito.verify(elementControllerMock, Mockito.times(1)).movePuffle(position);
        Mockito.verify(controllerMock, Mockito.times(1)).addScore(1, 1);
        Mockito.verify(elementControllerMock, Mockito.times(1)).removeKeyLock();
        Mockito.verify(elementControllerMock, Mockito.times(1)).setMelt(Mockito.any(MeltIce.class));
    }

    @Test
    public void interactSecret() {
        Secret testSecret = new Secret(position);
        InteractSecret interactTest = new InteractSecret(testSecret);

        Assert.assertFalse(interactTest.executeBox(elementControllerMock));
        Mockito.verify(elementControllerMock, Mockito.times(0)).moveBox(position);

        interactTest.executePuffle(controllerMock, elementControllerMock);
        Mockito.verify(elementControllerMock, Mockito.times(1)).movePuffle(position);
        Mockito.verify(controllerMock, Mockito.times(1)).addScore(1, 1);
        Mockito.verify(controllerMock, Mockito.times(1)).initSecretLevel();

        Assert.assertTrue(testSecret.getInteraction() instanceof InteractStop);
        Mockito.verify(elementControllerMock, Mockito.times(1)).setMelt(Mockito.any(MeltIce.class));
    }

    @Test
    public void interactStop() {
        Wall testWall = new Wall(position);
        InteractStop interactTest = new InteractStop(testWall);

        Assert.assertFalse(interactTest.executeBox(elementControllerMock));
        Mockito.verify(elementControllerMock, Mockito.times(0)).moveBox(position);

        interactTest.executePuffle(controllerMock, elementControllerMock);
        Mockito.verify(elementControllerMock, Mockito.times(0)).movePuffle(position);
    }

    @Test
    public void interactTeleport() {
        Position teleport1 = position;
        Position teleport2 = new Position(1, 1);

        Teleport testTeleport1 = new Teleport(teleport1);
        Teleport testTeleport2 = new Teleport(teleport2);
        List<Teleport> teleportList = new ArrayList<>();
        teleportList.add(testTeleport1);
        teleportList.add(testTeleport2);

        InteractTeleport interactTest1 = new InteractTeleport(testTeleport1);
        Mockito.when(elementControllerMock.getTeleportPosition(testTeleport1)).thenReturn(teleport2);
        Mockito.when(elementControllerMock.getTeleport()).thenReturn(teleportList);

        Assert.assertTrue(interactTest1.executeBox(elementControllerMock));
        Mockito.verify(elementControllerMock, Mockito.times(1)).moveBox(teleport2);
        interactTest1.executePuffle(controllerMock, elementControllerMock);
        Mockito.verify(elementControllerMock, Mockito.times(1)).movePuffle(teleport2);
        Mockito.verify(controllerMock, Mockito.times(1)).addScore(1, 1);

        Assert.assertTrue(testTeleport1.getInteraction() instanceof InteractStop);
        Assert.assertTrue(testTeleport2.getInteraction() instanceof InteractStop);

        Assert.assertEquals("#0000ff", testTeleport1.getColorForeground());
        Assert.assertEquals("#0000ff", testTeleport2.getColorForeground());

        Mockito.verify(elementControllerMock, Mockito.times(1)).setMelt(Mockito.any(MeltIce.class));
    }
}
