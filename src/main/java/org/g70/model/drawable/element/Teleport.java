package org.g70.model.drawable.element;

import org.g70.controller.level.interact.InteractTeleport;
import org.g70.model.Position;

public class Teleport extends ElementModel{
    public Teleport(Position position) {
        super("\u2588", "#4bd388", position);

        setInteraction(new InteractTeleport(this));
    }
}
