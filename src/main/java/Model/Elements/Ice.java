package Model.Elements;

import Controller.Interact.InteractIce;
import Model.Position;

public class Ice extends ElementModel {
    public Ice(Position position) {
        super(" ","#8dc5f0",position);

        this.setInteraction(new InteractIce(this));
    }
}
