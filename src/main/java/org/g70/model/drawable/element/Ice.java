package org.g70.model.drawable.element;

import org.g70.controller.level.interact.ice.InteractIce;
import org.g70.model.Position;

public class Ice extends ElementModel {
    public Ice(Position position) {
        super(" ","#8dc5f0",position);

        this.setInteraction(new InteractIce(this));
    }
}
