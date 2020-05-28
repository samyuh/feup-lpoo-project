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

        Assert.assertEquals(opt1.getImage(), "OptionA");
        Assert.assertEquals(opt1.getColorForeground(), "#FFFFFF");
        Assert.assertEquals(opt1.getColorBackground(), "#000077");
        Assert.assertEquals(opt1.getCommandOption(), mockOpt1);
        Assert.assertEquals(opt1.getPosition(), posMock);

        opt1.highlightedColor();
        Assert.assertEquals(opt1.getColorBackground(), "#120A8F");

        opt1.resetColor();
        Assert.assertEquals(opt1.getColorBackground(), "#000077");
    }
}
