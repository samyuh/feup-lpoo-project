package Model.Elements;

import Controller.Interact.InteractStop;
import Model.Position;

public class Water extends ElementModel {
    public Water(Position position) {
        super("W", "#0056AC",position);

        this.setInteraction(new InteractStop(this));
    }
}
