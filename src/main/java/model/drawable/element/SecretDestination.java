package model.drawable.element;

import controller.interact.InteractDestination;
import controller.interact.InteractSecretDestination;
import controller.interact.InteractStop;
import model.Position;

public class SecretDestination extends ElementModel {
    public SecretDestination(Position position) {
        super("\u2588", "#0065c6", position);

        this.setInteraction(new InteractSecretDestination(this));
    }
}
