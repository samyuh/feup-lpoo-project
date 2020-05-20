package org.g70.model.drawable.element;

import org.g70.controller.level.boxinteract.BoxInteractTeleport;
import org.g70.controller.level.puffleinteract.PuffleInteractTeleport;
import org.g70.model.Position;

public class Teleport extends ElementModel{
    public Teleport(Position position) {
        super("\u2588", "#4bd388", position);

        this.setPuffleInteraction(new PuffleInteractTeleport(this));

        this.setBoxInteraction(new BoxInteractTeleport(this));
    }
}
