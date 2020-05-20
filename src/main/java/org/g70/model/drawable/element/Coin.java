package org.g70.model.drawable.element;

import org.g70.controller.level.interact.items.InteractCoin;
import org.g70.model.Position;

public class Coin extends ElementModel {
    public Coin(Position position) {
        super("$", "#FFFF33", position);

        this.setInteraction(new InteractCoin(this));
    }
}