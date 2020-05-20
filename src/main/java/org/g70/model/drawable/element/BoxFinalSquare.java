package org.g70.model.drawable.element;

import org.g70.controller.level.boxinteract.BoxInteractMove;
import org.g70.controller.level.puffleinteract.PuffleInteractBoxFinalSquare;
import org.g70.model.Position;

public class BoxFinalSquare extends ElementModel {
    public BoxFinalSquare(Position position) {
        super("\u2588", "#0000FF", position);

        this.setPuffleInteraction(new PuffleInteractBoxFinalSquare(this));

        this.setBoxInteraction(new BoxInteractMove(this));
    }
}
