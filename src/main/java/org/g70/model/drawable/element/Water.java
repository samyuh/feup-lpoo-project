package org.g70.model.drawable.element;

import org.g70.controller.level.interact.InteractStop;
import org.g70.model.Position;

public class Water extends ElementModel {
    public Water(Position position) {
        super("W", "#0056AC",position);

        setInteraction(new InteractStop(this));
    }
}
