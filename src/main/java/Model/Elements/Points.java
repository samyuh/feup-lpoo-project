package Model.Elements;

import Model.Game.Position;

public class Points extends ElementModel {
    private int number;

    public Points(int number) {
        super("P", "#000000", new Position(20,0));
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
