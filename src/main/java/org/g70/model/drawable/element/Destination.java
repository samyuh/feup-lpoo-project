package org.g70.model.drawable.element;

import org.g70.controller.level.boxinteract.BoxInteractStop;
import org.g70.controller.level.puffleinteract.PuffleInteractDestination;
import org.g70.model.Position;

public class Destination extends ElementModel {
    public Destination(Position position) {
        super("D", "#ff0422", position);

        this.setPuffleInteraction(new PuffleInteractDestination(this));

        this.setBoxInteraction(new BoxInteractStop(this));
    }
}
