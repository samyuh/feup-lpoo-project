package org.g70.model.drawable.element;

import org.g70.controller.level.interact.InteractToughIce;
import org.g70.model.Position;

public class DoubleIce extends ElementModel {
    public DoubleIce(Position position) {
        super("\u2588", "#ffffff", position);

        this.setInteraction(new InteractToughIce(this));
    }
}
