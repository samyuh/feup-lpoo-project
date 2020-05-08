package Model.Option;

import Controller.CommandOption.CommandOption;
import Model.Position;

public class OptionModel {
    String name;
    String color;
    Position position;
    CommandOption opt;
    
    public OptionModel(String name, Position p, CommandOption opt) {
        this.name = name;
        this.color = "#000077";
        this.position = p;
        this.opt = opt;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public CommandOption getCommandOption() {
        return opt;
    }

    public void resetColor() {this.color = "#000077"; }

    public void selectedColor() {this.color = "#120A8F"; }
}
