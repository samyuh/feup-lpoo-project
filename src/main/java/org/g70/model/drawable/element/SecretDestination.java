package org.g70.model.drawable.element;

import org.g70.controller.level.boxInteract.BoxInteractStop;
import org.g70.controller.level.interact.level.InteractSecretDestination;
import org.g70.model.Position;

public class SecretDestination extends ElementModel {
    public SecretDestination(Position position) {
        super("\u2588", "#0065c6", position);

        this.setInteraction(new InteractSecretDestination(this));

        this.setBoxInteraction(new BoxInteractStop(this));
    }
}
