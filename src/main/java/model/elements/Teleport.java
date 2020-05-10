package model.elements;

import controller.interact.InteractTeleport;
import model.Position;

public class Teleport extends ElementModel{
    public Teleport(Position position) {
        super("\u2588", "#4bd388", position);

        this.setInteraction(new InteractTeleport(this));
    }
}
