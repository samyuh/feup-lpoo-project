package Model.Elements;

import Model.Position;

public class Points extends ElementModel {
    private int number;

    public Points(int number) {
        super(Integer.toString(number), "#000000", new Position(20,0));
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
