package Model.Elements;

import Controller.Interact.InteractDestination;
import Model.Position;

public class Destination extends ElementModel {
    public Destination(Position position) {
        super("D", "#ff0422", position);

        this.setInteraction(new InteractDestination(this));
    }
}
