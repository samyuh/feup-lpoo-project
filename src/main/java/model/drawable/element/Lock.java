package model.drawable.element;

import controller.level.interact.level.InteractStop;
import model.Position;

public class Lock extends ElementModel {
    public Lock(Position position) {
        super("L", "#A0522D", position);

        this.setInteraction(new InteractStop(this));
    }
}
