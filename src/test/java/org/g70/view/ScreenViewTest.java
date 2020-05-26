package org.g70.view;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ScreenViewTest {
    @Test
    public void screenTest() {
        try {
            ScreenView scrV = new ScreenView(55, 21);

            Assert.assertNotNull(scrV.getScreen());

            Assert.assertEquals(scrV.getScreen().getTerminalSize().getColumns(), 55);
            Assert.assertEquals(scrV.getScreen().getTerminalSize().getRows(), 21);

            Assert.assertNull(scrV.getScreen().getCursorPosition());
            scrV.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
