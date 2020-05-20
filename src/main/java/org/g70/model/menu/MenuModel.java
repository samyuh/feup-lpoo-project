package org.g70.model.menu;

import org.g70.controller.menu.option.Option;
import org.g70.model.drawable.Drawable;
import org.g70.model.drawable.menu.MenuOption;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuModel {
    protected int optionNum;
    protected List<MenuOption> option;
    protected List<Drawable> textBoxes;

    MenuModel(List<MenuOption> option) {
        optionNum = 0;
        this.option = option;

        this.textBoxes = new ArrayList<>();

        resetColor();
        updateColor();
    }

    public void previousAction() {
        if(optionNum != 0) optionNum--;
        else optionNum = option.size() - 1;

        resetColor();
        updateColor();
    }

    public void nextAction() {
        optionNum = (optionNum + 1) % option.size();

        resetColor();
        updateColor();
    }

    private void resetColor() {
        for(MenuOption option : option)
            option.resetColor();
    }

    private void updateColor() {
        option.get(optionNum).highlightedColor();
    }

    public List<MenuOption> getOption() {
        return option;
    }

    public Option getAction() {
        return option.get(optionNum).getCommandOption();
    }

    public List<Drawable> getTextBoxes() {
        return textBoxes;
    }

    protected abstract void initTextBoxes();
}
