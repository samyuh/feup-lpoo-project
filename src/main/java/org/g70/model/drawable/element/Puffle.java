package org.g70.model.drawable.element;

import org.g70.controller.level.interact.InteractPuffle;
import org.g70.model.Position;

public class Puffle extends ElementModel {
    public Puffle(Position position) {
        super("\u25CF", "#ff0422", position);
        setInteraction(new InteractPuffle(this));
    }
}
