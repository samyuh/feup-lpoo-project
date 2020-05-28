package org.g70.view.handler;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.g70.view.ScreenView;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;


public class KeyHandlerTest {
    @Test
    public void handlerTest() throws IOException {
        // Create a Stub for Screen and keyPressed
        Screen scrMock = Mockito.mock(Screen.class);
        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);

        KeyStroke keyUp = Mockito.mock(KeyStroke.class);
        Mockito.when(keyUp.getKeyType()).thenReturn(KeyType.ArrowUp);

        KeyStroke keyRight = Mockito.mock(KeyStroke.class);
        Mockito.when(keyRight.getKeyType()).thenReturn(KeyType.ArrowRight);

        KeyStroke keyDown = Mockito.mock(KeyStroke.class);
        Mockito.when(keyDown.getKeyType()).thenReturn(KeyType.ArrowDown);

        KeyStroke keyLeft = Mockito.mock(KeyStroke.class);
        Mockito.when(keyLeft.getKeyType()).thenReturn(KeyType.ArrowLeft);

        KeyStroke keyEOF = Mockito.mock(KeyStroke.class);
        Mockito.when(keyEOF.getKeyType()).thenReturn(KeyType.EOF);

        KeyStroke keyN = Mockito.mock(KeyStroke.class);
        Mockito.when(keyN.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyN.getCharacter()).thenReturn('n');

        KeyStroke keyR = Mockito.mock(KeyStroke.class);
        Mockito.when(keyR.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyR.getCharacter()).thenReturn('r');

        KeyStroke keyQ = Mockito.mock(KeyStroke.class);
        Mockito.when(keyQ.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyQ.getCharacter()).thenReturn('q');


        // -- Tests

        Mockito.when(scrMock.readInput()).thenReturn(keyUp);
        Assert.assertEquals(KeyHandler.processKey(scrMock), KeyHandler.KEY.UP);

        Mockito.when(scrMock.readInput()).thenReturn(keyRight);
        Assert.assertEquals(KeyHandler.processKey(scrMock), KeyHandler.KEY.RIGHT);

        Mockito.when(scrMock.readInput()).thenReturn(keyDown);
        Assert.assertEquals(KeyHandler.processKey(scrMock), KeyHandler.KEY.DOWN);

        Mockito.when(scrMock.readInput()).thenReturn(keyLeft);
        Assert.assertEquals(KeyHandler.processKey(scrMock), KeyHandler.KEY.LEFT);

        Mockito.when(scrMock.readInput()).thenReturn(keyEOF);
        Assert.assertEquals(KeyHandler.processKey(scrMock), KeyHandler.KEY.CLOSE);

        Mockito.when(scrMock.readInput()).thenReturn(keyN);
        Assert.assertEquals(KeyHandler.processKey(scrMock), KeyHandler.KEY.NEXT);

        Mockito.when(scrMock.readInput()).thenReturn(keyR);
        Assert.assertEquals(KeyHandler.processKey(scrMock), KeyHandler.KEY.RESTART);

        Mockito.when(scrMock.readInput()).thenReturn(keyQ);
        Assert.assertEquals(KeyHandler.processKey(scrMock), KeyHandler.KEY.CLOSE);
    }
}
