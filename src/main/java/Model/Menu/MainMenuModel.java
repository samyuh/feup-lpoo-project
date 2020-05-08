package Model.Menu;

import Controller.CommandOption.CommandOption;
import Controller.CommandOption.CommandOptionExit;
import Controller.CommandOption.CommandOptionNewGame;
import Model.Option.OptionModel;
import Model.Position;

import java.util.ArrayList;
import java.util.List;

public class MainMenuModel {
    private int optionNum;
    private List<OptionModel> op;

    public MainMenuModel() {
        optionNum = 0;
        this.op = new ArrayList<>();
        this.op.add(new OptionModel("Start", "#120A8F", new Position(2, 14), new CommandOptionNewGame()));
        this.op.add(new OptionModel("Instructions", "#000077", new Position(2, 15), new CommandOptionNewGame()));
        this.op.add(new OptionModel("Exit", "#000077", new Position(2, 16), new CommandOptionExit()));
    }

    public List<OptionModel> getOption() {
        return op;
    }

    public void previousAction() {
        if(optionNum != 0) optionNum--;
        else optionNum = 2;

        resetColor();

        updateColor();
    }

    public void nextAction() {
        optionNum = (optionNum + 1) % 3;

        resetColor();

        updateColor();
    }

    public void resetColor() {
        op.get(0).setColor("#000077");
        op.get(1).setColor("#000077");
        op.get(2).setColor("#000077");
    }

    public void updateColor() {
        op.get(optionNum).setColor("#120A8F");
    }

    public CommandOption getAction() {
        return op.get(optionNum).getCommandOption();
    }
}
