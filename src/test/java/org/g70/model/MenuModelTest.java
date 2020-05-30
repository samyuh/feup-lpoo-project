package org.g70.model;

import org.g70.controller.menu.option.Option;
import org.g70.controller.menu.option.OptionExit;
import org.g70.controller.menu.option.OptionHelp;
import org.g70.controller.menu.option.OptionNewGame;
import org.g70.model.drawable.menudrawable.MenuOption;
import org.g70.model.menu.GameOverModel;
import org.g70.model.menu.HelpModel;
import org.g70.model.menu.MainMenuModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MenuModelTest {
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
        Assert.assertEquals("#120A8F", mainMenuTest.getOptions().get(0).getColorBackground());
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(1).getColorBackground());
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(2).getColorBackground());

        mainMenuTest.previousAction();
        Assert.assertTrue(mainMenuTest.getAction() instanceof OptionNewGame);
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(0).getColorBackground());
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(1).getColorBackground());
        Assert.assertEquals("#120A8F", mainMenuTest.getOptions().get(2).getColorBackground());

        mainMenuTest.nextAction();
        Assert.assertTrue(mainMenuTest.getAction() instanceof OptionExit);
        Assert.assertEquals("#120A8F", mainMenuTest.getOptions().get(0).getColorBackground());
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(1).getColorBackground());
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(2).getColorBackground());

        mainMenuTest.nextAction();
        Assert.assertTrue(mainMenuTest.getAction() instanceof OptionHelp);
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(0).getColorBackground());
        Assert.assertEquals("#120A8F", mainMenuTest.getOptions().get(1).getColorBackground());
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(2).getColorBackground());

        mainMenuTest.nextAction();
        Assert.assertTrue(mainMenuTest.getAction() instanceof OptionNewGame);
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(0).getColorBackground());
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(1).getColorBackground());
        Assert.assertEquals("#120A8F", mainMenuTest.getOptions().get(2).getColorBackground());

        mainMenuTest.nextAction();
        Assert.assertTrue(mainMenuTest.getAction() instanceof OptionExit);
        Assert.assertEquals("#120A8F", mainMenuTest.getOptions().get(0).getColorBackground());
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(1).getColorBackground());
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(2).getColorBackground());

        mainMenuTest.previousAction();
        Assert.assertTrue(mainMenuTest.getAction() instanceof OptionNewGame);
        Assert.assertEquals("#000077",mainMenuTest.getOptions().get(0).getColorBackground());
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(1).getColorBackground());
        Assert.assertEquals("#120A8F", mainMenuTest.getOptions().get(2).getColorBackground());

        mainMenuTest.previousAction();
        Assert.assertTrue(mainMenuTest.getAction() instanceof OptionHelp);
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(0).getColorBackground());
        Assert.assertEquals("#120A8F", mainMenuTest.getOptions().get(1).getColorBackground());
        Assert.assertEquals("#000077", mainMenuTest.getOptions().get(2).getColorBackground());

        Assert.assertEquals(mainMenuTest.getOptions().size(), 3);
    }

    @Test
    public void textBoxes() {
        Assert.assertFalse(mainMenuTest.getTextBoxes().isEmpty());
        Assert.assertFalse(helpMenuTest.getTextBoxes().isEmpty());
        Assert.assertFalse(gameOverMenuTest.getTextBoxes().isEmpty());
    }
}
