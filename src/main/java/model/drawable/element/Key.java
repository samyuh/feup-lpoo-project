package model.drawable.element;

import controller.level.interact.items.InteractKey;
import model.Position;

public class Key extends ElementModel {
    public Key(Position position) {
        super("K", "#A0522D", position);

        this.setInteraction(new InteractKey(this));
    }
}
