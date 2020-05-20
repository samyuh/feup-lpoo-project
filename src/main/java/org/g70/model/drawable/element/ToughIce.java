package org.g70.model.drawable.element;

import org.g70.controller.level.boxinteract.BoxInteractMove;
import org.g70.controller.level.puffleinteract.PuffleInteractToughIce;
import org.g70.model.Position;

public class ToughIce extends ElementModel {
    public ToughIce(Position position) {
        super("\u2588", "#ffffff", position);

        this.setPuffleInteraction(new PuffleInteractToughIce(this));

        this.setBoxInteraction(new BoxInteractMove(this));
    }
}
