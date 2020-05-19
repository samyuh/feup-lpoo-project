package model.drawable.element;

import controller.level.interact.ice.InteractIce;
import model.Position;

public class Ice extends ElementModel {
    public Ice(Position position) {
        super(" ","#8dc5f0",position);

        this.setInteraction(new InteractIce(this));
    }
}
