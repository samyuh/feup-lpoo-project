package Model.Elements;

import Controller.Interact.InteractStop;
import Model.Position;

public class Lock extends ElementModel {
    public Lock(Position position) {
        super("L", "#A0522D", position);

        this.setInteraction(new InteractStop(this));
    }
}
