package org.g70.model.drawable.element;

import org.g70.controller.level.interact.InteractStop;
import org.g70.model.Position;

public class Lock extends ElementModel {
    public Lock(Position position) {
        super("L", "#A0522D", position);

        setInteraction(new InteractStop(this));
    }
}
