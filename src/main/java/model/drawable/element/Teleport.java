package model.drawable.element;

import controller.level.interact.level.InteractTeleport;
import model.Position;

public class Teleport extends ElementModel{
    public Teleport(Position position) {
        super("\u2588", "#4bd388", position);

        this.setInteraction(new InteractTeleport(this));
    }
}
