package org.g70.model.drawable.element.movable;

import org.g70.controller.level.interact.InteractBox;
import org.g70.model.Position;

public class Box extends MovableElement {
    public Box(Position position) {
        super("O", "#0079d0", position);

        interaction = new InteractBox(this);
    }
}
