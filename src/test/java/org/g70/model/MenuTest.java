package org.g70.model;

import org.g70.controller.menu.option.Option;
import org.g70.controller.menu.option.OptionExit;
import org.g70.controller.menu.option.OptionHelp;
import org.g70.controller.menu.option.OptionNewGame;
import org.g70.model.drawable.menu.MenuOption;
import org.g70.model.menu.GameOverModel;
import org.g70.model.menu.HelpModel;
import org.g70.model.menu.MainMenuModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MenuTest {
    MainMenuModel mainMenuTest;
    HelpModel helpMenuTest;
    GameOverModel gameOverMenuTest;
    List<MenuOption> options;

    @Before
    public void initOptions() {
        options = new ArrayList<>();
        Option mockOpt1 = Mockito.mock(OptionExit.class);
        Option mockOpt2 = Mockito.mock(OptionHelp.class);
        Option mockOpt3 = Mockito.mock(OptionNewGame.class);
        options.add(new MenuOption("OptionA", new Position(2, 16), mockOpt1));
        options.add(new MenuOption("OptionB", new Position(2, 17), mockOpt2));
        options.add(new MenuOption("OptionC", new Position(2, 18), mockOpt3));

        mainMenuTest = new MainMenuModel(options);
        helpMenuTest = new HelpModel(options);
        gameOverMenuTest = new GameOverModel(options, 1);
    }

    @Test
    public void menuOptionsTest() {
        Assert.assertTrue(mainMenuTest.getAction() instanceof OptionExit);
        Assert.assertEquals(mainMenuTest.getOptions().get(0).getColorBackground(), "#120A8F");
        Assert.assertEquals(mainMenuTest.getOptions().get(1).getColorBackground(), "#000077");
        Assert.assertEquals(mainMenuTest.getOptions().get(2).getColorBackground(), "#000077");

        mainMenuTest.nextAction();
        Assert.assertTrue(mainMenuTest.getAction() instanceof OptionHelp);
        Assert.assertEquals(mainMenuTest.getOptions().get(0).getColorBackground(), "#000077");
        Assert.assertEquals(mainMenuTest.getOptions().get(1).getColorBackground(), "#120A8F");
        Assert.assertEquals(mainMenuTest.getOptions().get(2).getColorBackground(), "#000077");

        mainMenuTest.nextAction();
        Assert.assertTrue(mainMenuTest.getAction() instanceof OptionNewGame);

        mainMenuTest.nextAction();
        Assert.assertTrue(mainMenuTest.getAction() instanceof OptionExit);

        mainMenuTest.previousAction();
        Assert.assertTrue(mainMenuTest.getAction() instanceof OptionNewGame);
        Assert.assertEquals(mainMenuTest.getOptions().get(0).getColorBackground(), "#000077");
        Assert.assertEquals(mainMenuTest.getOptions().get(1).getColorBackground(), "#000077");
        Assert.assertEquals(mainMenuTest.getOptions().get(2).getColorBackground(), "#120A8F");

        Assert.assertEquals(mainMenuTest.getOptions().size(), 3);
    }

    @Test
    public void textBoxes() {
        // To Do
    }
}
