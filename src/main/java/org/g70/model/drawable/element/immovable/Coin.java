package org.g70.model.drawable.element.immovable;

import org.g70.controller.level.interact.InteractCoin;
import org.g70.model.Position;

public class Coin extends ImmovableElement {
    public Coin(Position position) {
        super("$", "#FFFF33", position);

        interaction = new InteractCoin(this);
    }
}