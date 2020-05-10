package model.menu;

import controller.option.Option;
import model.option.OptionModel;

import java.util.List;

public class MenuModel {
    private int optionNum;
    private List<OptionModel> op;

    public MenuModel(List<OptionModel> op) {
        optionNum = 0;
        this.op = op;

        resetColor();
        updateColor();
    }

    public List<OptionModel> getOption() {
        return op;
    }

    public void previousAction() {
        if(optionNum != 0) optionNum--;
        else optionNum = op.size() - 1;

        resetColor();
        updateColor();
    }

    public void nextAction() {
        optionNum = (optionNum + 1) % op.size();

        resetColor();
        updateColor();
    }

    public void resetColor() {
        for(OptionModel option : op)
            option.resetColor();
    }

    public void updateColor() {
        op.get(optionNum).selectedColor();
    }

    public Option getAction() {
        return op.get(optionNum).getCommandOption();
    }
}
