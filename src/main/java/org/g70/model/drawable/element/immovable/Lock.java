package org.g70.model.drawable.element.immovable;

import org.g70.controller.level.interact.InteractStop;
import org.g70.model.Position;

public class Lock extends ImmovableElement {
    public Lock(Position position) {
        super("L", "#A0522D", position);

        interaction = new InteractStop(this);
    }
}
