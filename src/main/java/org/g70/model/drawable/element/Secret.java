package org.g70.model.drawable.element;

import org.g70.controller.level.interact.InteractSecret;
import org.g70.model.Position;

public class Secret extends ElementModel {
    public Secret(Position position) {
        super("\u2588", "#0065c6", position);

        setInteraction(new InteractSecret(this));
    }
}
