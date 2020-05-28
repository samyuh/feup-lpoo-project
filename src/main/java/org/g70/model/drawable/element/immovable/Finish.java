package org.g70.model.drawable.element.immovable;

import org.g70.controller.level.interact.InteractFinish;
import org.g70.model.Position;

public class Finish extends ImmovableElement {
    public Finish(Position position) {
        super("D", "#ff0422", position);

        setInteraction(new InteractFinish(this));
    }
}
