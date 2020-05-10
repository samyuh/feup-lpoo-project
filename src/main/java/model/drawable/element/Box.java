package model.drawable.element;

import controller.interact.InteractBox;
import model.Position;

public class Box extends ElementModel {
    public Box(Position position) {
        super("O", "#0079d0", position);

        this.setInteraction(new InteractBox(this));
    }
}
