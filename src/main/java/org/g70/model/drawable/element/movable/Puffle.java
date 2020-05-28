package org.g70.model.drawable.element.movable;

import org.g70.controller.level.interact.InteractStop;
import org.g70.model.Position;

public class Puffle extends MovableElement {
    public Puffle(Position position) {
        super("\u25CF", "#ff0422", position);
        setInteraction(new InteractStop(this));
    }
}
