package Model.Elements;

import Controller.Interact.InteractKey;
import Model.Position;

public class Key extends ElementModel {
    public Key(Position position) {
        super("I", "#A0522D", position);

        this.setInteraction(new InteractKey(this));
    }
}
