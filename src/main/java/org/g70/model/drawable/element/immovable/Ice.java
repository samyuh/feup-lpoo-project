package org.g70.model.drawable.element.immovable;

import org.g70.controller.level.interact.InteractIce;
import org.g70.model.Position;

public class Ice extends ImmovableElement {
    public Ice(Position position) {
        super(" ","#8dc5f0",position);

        interaction = new InteractIce(this);
    }
}
