package model.drawable.element;

import controller.level.interact.items.InteractCoin;
import model.Position;

public class Coin extends ElementModel {
    public Coin(Position position) {
        super("$", "#FFFF33", position);

        this.setInteraction(new InteractCoin(this));
    }
}