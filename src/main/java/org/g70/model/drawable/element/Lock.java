package org.g70.model.drawable.element;

import org.g70.controller.level.boxinteract.BoxInteractStop;
import org.g70.controller.level.puffleinteract.PuffleInteractStop;
import org.g70.model.Position;

public class Lock extends ElementModel {
    public Lock(Position position) {
        super("L", "#A0522D", position);

        this.setPuffleInteraction(new PuffleInteractStop(this));

        this.setBoxInteraction(new BoxInteractStop(this));
    }
}
