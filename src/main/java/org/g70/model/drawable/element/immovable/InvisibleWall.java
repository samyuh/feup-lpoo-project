package org.g70.model.drawable.element.immovable;

import org.g70.controller.level.interact.InteractInvisibleWall;
import org.g70.model.Position;

public class InvisibleWall extends ImmovableElement {
    public InvisibleWall(Position position) {
        super("\u2588", "#0065c6", position);

        interaction = new InteractInvisibleWall(this);
    }
}
