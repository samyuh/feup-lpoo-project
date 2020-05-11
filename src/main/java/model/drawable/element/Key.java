package model.drawable.element;

import controller.interact.InteractKey;
import model.Position;

public class Key extends ElementModel {
    public Key(Position position) {
        super("I", "#A0522D", position);

        this.setInteraction(new InteractKey(this));
    }
}
