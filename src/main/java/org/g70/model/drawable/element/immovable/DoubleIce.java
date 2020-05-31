package org.g70.model.drawable.element.immovable;

import org.g70.controller.level.interact.InteractDoubleIce;
import org.g70.model.Position;

public class DoubleIce extends ImmovableElement {
    public DoubleIce(Position position) {
        super("\u2588", "#ffffff", position);

        interaction = new InteractDoubleIce(this);
    }
}
