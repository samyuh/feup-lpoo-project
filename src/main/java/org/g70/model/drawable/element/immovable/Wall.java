package org.g70.model.drawable.element.immovable;

import org.g70.controller.level.interact.InteractStop;
import org.g70.model.Position;

public class Wall extends ImmovableElement {
    public Wall(Position position) {
        super("\u2588", "#0065c6", position);

        setInteraction(new InteractStop(this));
    }
}

