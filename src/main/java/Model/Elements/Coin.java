package Model.Elements;

import Model.Position;

public class Coin extends ElementModel {
    public Coin(Position position) {
        super("$", "#FFFF33", position);
    }
}