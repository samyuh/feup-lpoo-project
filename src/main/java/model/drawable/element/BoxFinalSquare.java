package model.drawable.element;

import controller.interact.InteractBoxFinalSquare;
import model.Position;

public class BoxFinalSquare extends ElementModel {
    public BoxFinalSquare(Position position) {
        super("\u2588", "#0000FF", position);

        this.setInteraction(new InteractBoxFinalSquare(this));
    }
}
