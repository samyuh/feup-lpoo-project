package org.g70.model.drawable;

import org.g70.controller.menu.option.Option;
import org.g70.controller.menu.option.OptionExit;
import org.g70.model.Position;
import org.g70.model.drawable.menudrawable.MenuOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MenuDrawableTest {
    private Position posMock;

    @Before
    public void initOptionMock() {
        posMock = Mockito.mock(Position.class);
        Mockito.when(posMock.getX()).thenReturn(0);
        Mockito.when(posMock.getY()).thenReturn(0);
    }

    @Test
    public void menuOptionTest() {
        Option mockOpt1 = Mockito.mock(OptionExit.class);
        MenuOption opt1 = new MenuOption("OptionA", posMock, mockOpt1);

        Assert.assertEquals("OptionA", opt1.getImage());
        Assert.assertEquals("#FFFFFF", opt1.getColorForeground());
        Assert.assertEquals("#000077", opt1.getColorBackground());
        Assert.assertEquals(mockOpt1, opt1.getCommandOption());
        Assert.assertEquals(posMock, opt1.getPosition());

        opt1.highlightedColor();
        Assert.assertEquals("#120A8F", opt1.getColorBackground());

        opt1.resetColor();
        Assert.assertEquals("#000077", opt1.getColorBackground());
    }
}
