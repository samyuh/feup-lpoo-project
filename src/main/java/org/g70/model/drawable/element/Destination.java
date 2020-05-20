package org.g70.model.drawable.element;

import org.g70.controller.level.boxInteract.BoxInteractStop;
import org.g70.controller.level.interact.level.InteractDestination;
import org.g70.model.Position;

public class Destination extends ElementModel {
    public Destination(Position position) {
        super("D", "#ff0422", position);

        this.setInteraction(new InteractDestination(this));

        this.setBoxInteraction(new BoxInteractStop(this));
    }
}
