package Model.Option;

import Controller.CommandOption.CommandOption;
import Model.Position;

public class OptionModel {
    String name;
    String color;
    Position position;
    CommandOption opt;
    
    public OptionModel(String name, String color, Position p, CommandOption opt) {
        this.name = name;
        this.color = color;
        this.position = p;
        this.opt = opt;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public CommandOption getCommandOption() {
        return opt;
    }
}
