package org.g70.model.drawable.element;

import org.g70.controller.level.boxinteract.BoxInteractStop;
import org.g70.controller.level.puffleinteract.PuffleInteractBox;
import org.g70.model.Position;

public class Box extends ElementModel {
    public Box(Position position) {
        super("O", "#0079d0", position);

        this.setPuffleInteraction(new PuffleInteractBox(this));

        this.setBoxInteraction(new BoxInteractStop(this));
    }
}
