package org.g70.model.drawable.element;

import org.g70.controller.level.interact.ice.InteractToughIce;
import org.g70.model.Position;

public class ToughIce extends ElementModel {
    public ToughIce(Position position) {
        super("\u2588", "#ffffff", position);

        this.setInteraction(new InteractToughIce(this));
    }
}
