package org.g70.model.drawable.element;

import org.g70.controller.level.interact.InteractStop;
import org.g70.model.Position;

public class Wall extends ElementModel {
    public Wall(Position position) {
        super("\u2588", "#0065c6", position);

        this.setInteraction(new InteractStop(this));
    }
}

