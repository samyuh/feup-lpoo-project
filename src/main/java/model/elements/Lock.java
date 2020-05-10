package model.elements;

import controller.interact.InteractStop;
import model.Position;

public class Lock extends ElementModel {
    public Lock(Position position) {
        super("L", "#A0522D", position);

        this.setInteraction(new InteractStop(this));
    }
}
