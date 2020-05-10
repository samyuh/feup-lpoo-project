package Model.Elements;

import Controller.Interact.InteractBox;
import Model.Position;

public class Box extends ElementModel {
    public Box(Position position) {
        super("O", "#0079d0", position);

        this.setInteraction(new InteractBox(this));
    }
}
