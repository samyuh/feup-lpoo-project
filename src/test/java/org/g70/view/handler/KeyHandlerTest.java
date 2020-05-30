package org.g70.view.handler;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.g70.view.ScreenView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;


public class KeyHandlerTest {
    Screen scrMock;
    private KeyStroke keyUp;
    private KeyStroke keyDown;
    private KeyStroke keyLeft;
    private KeyStroke keyRight;
    private KeyStroke keyEOF;
    private KeyStroke keyN;
    private KeyStroke keyR;
    private KeyStroke keyQ;

    @Before
    public void initKeys() {
        scrMock = Mockito.mock(Screen.class);
        ScreenView screenMock = Mockito.mock(ScreenView.class);
        Mockito.when(screenMock.getScreen()).thenReturn(scrMock);

        keyUp = Mockito.mock(KeyStroke.class);
        Mockito.when(keyUp.getKeyType()).thenReturn(KeyType.ArrowUp);

        keyRight = Mockito.mock(KeyStroke.class);
        Mockito.when(keyRight.getKeyType()).thenReturn(KeyType.ArrowRight);

        keyDown = Mockito.mock(KeyStroke.class);
        Mockito.when(keyDown.getKeyType()).thenReturn(KeyType.ArrowDown);

        keyLeft = Mockito.mock(KeyStroke.class);
        Mockito.when(keyLeft.getKeyType()).thenReturn(KeyType.ArrowLeft);

        keyEOF = Mockito.mock(KeyStroke.class);
        Mockito.when(keyEOF.getKeyType()).thenReturn(KeyType.EOF);

        keyN = Mockito.mock(KeyStroke.class);
        Mockito.when(keyN.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyN.getCharacter()).thenReturn('n');

        keyR = Mockito.mock(KeyStroke.class);
        Mockito.when(keyR.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyR.getCharacter()).thenReturn('r');

        keyQ = Mockito.mock(KeyStroke.class);
        Mockito.when(keyQ.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(keyQ.getCharacter()).thenReturn('q');
    }

    @Test
    public void handlerTest() throws IOException {
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
