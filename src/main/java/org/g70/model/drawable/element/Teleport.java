package org.g70.model.drawable.element;

import org.g70.controller.level.boxInteract.BoxInteractMove;
import org.g70.controller.level.boxInteract.BoxInteractStop;
import org.g70.controller.level.boxInteract.BoxInteractTeleport;
import org.g70.controller.level.interact.level.InteractTeleport;
import org.g70.model.Position;

public class Teleport extends ElementModel{
    public Teleport(Position position) {
        super("\u2588", "#4bd388", position);

        this.setInteraction(new InteractTeleport(this));

        this.setBoxInteraction(new BoxInteractTeleport(this));
    }
}
