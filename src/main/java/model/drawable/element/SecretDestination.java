package model.drawable.element;

import controller.level.interact.level.InteractSecretDestination;
import model.Position;

public class SecretDestination extends ElementModel {
    public SecretDestination(Position position) {
        super("\u2588", "#0065c6", position);

        this.setInteraction(new InteractSecretDestination(this));
    }
}
