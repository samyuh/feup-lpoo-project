package org.g70.model.drawable.element;

import org.g70.controller.level.boxinteract.BoxInteractStop;
import org.g70.controller.level.puffleinteract.PuffleInteractStop;
import org.g70.model.Position;

public class Water extends ElementModel {
    public Water(Position position) {
        super("W", "#0056AC",position);

        this.setPuffleInteraction(new PuffleInteractStop(this));

        this.setBoxInteraction(new BoxInteractStop(this));
    }
}
