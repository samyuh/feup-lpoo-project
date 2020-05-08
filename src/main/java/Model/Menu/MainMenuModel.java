package Model.Menu;

import Model.Option;
import Model.Position;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

import java.util.ArrayList;
import java.util.List;

public class MainMenuModel {
    private int optionNum;
    private List<Option> op;

    public MainMenuModel() {
        optionNum = 0;
        this.op = new ArrayList<>();
        this.op.add(new Option("Start", "#120A8F", new Position(2, 14)));
        this.op.add(new Option("Instructions", "#000077", new Position(2, 15)));
        this.op.add(new Option("Exit", "#000077", new Position(2, 16)));
    }

    public List<Option> getOption() {
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

    public int getAction() {
        return optionNum;
    }
}
