package model.drawable.element;

import controller.interact.InteractCoin;
import model.Position;

public class Coin extends ElementModel {
    public Coin(Position position) {
        super("$", "#FFFF33", position);

        this.setInteraction(new InteractCoin(this));
    }
}