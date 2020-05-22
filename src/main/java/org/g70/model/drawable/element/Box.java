package org.g70.model.drawable.element;

import org.g70.controller.level.interact.InteractBox;
import org.g70.model.Position;

public class Box extends ElementModel {
    public Box(Position position) {
        super("O", "#0079d0", position);

        this.setInteraction(new InteractBox(this));
    }
}
