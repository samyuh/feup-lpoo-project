package org.g70.model.drawable.element;

import org.g70.controller.level.interact.InteractDestination;
import org.g70.model.Position;

public class Finish extends ElementModel {
    public Finish(Position position) {
        super("D", "#ff0422", position);

        this.setInteraction(new InteractDestination(this));
    }
}
