package org.g70.model.drawable.element;

import org.g70.controller.level.boxinteract.BoxInteractStop;
import org.g70.controller.level.puffleinteract.PuffleInteractSecretDestination;
import org.g70.model.Position;

public class SecretDestination extends ElementModel {
    public SecretDestination(Position position) {
        super("\u2588", "#0065c6", position);

        this.setPuffleInteraction(new PuffleInteractSecretDestination(this));

        this.setBoxInteraction(new BoxInteractStop(this));
    }
}
