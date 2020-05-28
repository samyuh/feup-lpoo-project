package org.g70.model.drawable.element.immovable;

import org.g70.controller.level.interact.InteractKey;
import org.g70.model.Position;

public class Key extends ImmovableElement {
    public Key(Position position) {
        super("K", "#A0522D", position);

        setInteraction(new InteractKey(this));
    }
}
