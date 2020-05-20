package org.g70.model.drawable.element;

import org.g70.controller.level.boxinteract.BoxInteractMove;
import org.g70.controller.level.puffleinteract.PuffleInteractInvisibleWall;
import org.g70.model.Position;

public class InvisibleWall extends ElementModel {
    public InvisibleWall(Position position) {
        super("\u2588", "#0065c6", position);
        this.setPuffleInteraction(new PuffleInteractInvisibleWall(this));

        this.setBoxInteraction(new BoxInteractMove(this));
    }
}
