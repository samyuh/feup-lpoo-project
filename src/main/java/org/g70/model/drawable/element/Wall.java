package org.g70.model.drawable.element;

import org.g70.controller.level.boxinteract.BoxInteractStop;
import org.g70.controller.level.puffleinteract.PuffleInteractStop;
import org.g70.model.Position;

public class Wall extends ElementModel {
    public Wall(Position position) {
        super("\u2588", "#0065c6", position);

        this.setPuffleInteraction(new PuffleInteractStop(this));

        this.setBoxInteraction(new BoxInteractStop(this));
    }
}

