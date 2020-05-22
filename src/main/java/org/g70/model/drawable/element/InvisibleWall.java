package org.g70.model.drawable.element;

import org.g70.controller.level.interact.InteractInvisibleWall;
import org.g70.model.Position;

public class InvisibleWall extends ElementModel {
    public InvisibleWall(Position position) {
        super("\u2588", "#0065c6", position);

        setInteraction(new InteractInvisibleWall(this));
    }
}
