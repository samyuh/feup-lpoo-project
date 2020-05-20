package org.g70.model.drawable.element;

import org.g70.controller.level.interact.box.InteractBoxFinalSquare;
import org.g70.model.Position;

public class BoxFinalSquare extends ElementModel {
    public BoxFinalSquare(Position position) {
        super("\u2588", "#0000FF", position);

        this.setInteraction(new InteractBoxFinalSquare(this));
    }
}
