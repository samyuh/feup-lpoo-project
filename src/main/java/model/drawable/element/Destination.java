package model.drawable.element;

import controller.interact.InteractDestination;
import model.Position;

public class Destination extends ElementModel {
    public Destination(Position position) {
        super("D", "#ff0422", position);

        this.setInteraction(new InteractDestination(this));
    }
}
