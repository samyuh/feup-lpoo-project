package org.g70.model.drawable.element;

import org.g70.controller.level.interact.InteractKey;
import org.g70.model.Position;

public class Key extends ElementModel {
    public Key(Position position) {
        super("K", "#A0522D", position);

        setInteraction(new InteractKey(this));
    }
}
