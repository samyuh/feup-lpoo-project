package org.g70.model.drawable.element;

import org.g70.controller.level.interact.level.InteractStop;
import org.g70.model.Position;

public class Water extends ElementModel {
    public Water(Position position) {
        super("W", "#0056AC",position);

        this.setInteraction(new InteractStop(this));
    }
}
