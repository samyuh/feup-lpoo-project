package model.menu;

import controller.menu.option.Option;
import model.drawable.menu.MenuOption;

import java.util.List;

public class MenuModel {
    private int optionNum;
    private List<MenuOption> option;

    public MenuModel(List<MenuOption> option) {
        optionNum = 0;
        this.option = option;

        resetColor();
        updateColor();
    }

    public List<MenuOption> getOption() {
        return option;
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

    public void resetColor() {
        for(MenuOption option : option)
            option.resetColor();
    }

    public void updateColor() {
        option.get(optionNum).selectedColor();
    }

    public Option getAction() {
        return option.get(optionNum).getCommandOption();
    }
}
