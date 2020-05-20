package org.g70.model.drawable.element;

import org.g70.controller.level.boxinteract.BoxInteractMove;
import org.g70.controller.level.puffleinteract.PuffleInteractIce;
import org.g70.model.Position;

public class Ice extends ElementModel {
    public Ice(Position position) {
        super(" ","#8dc5f0",position);

        this.setPuffleInteraction(new PuffleInteractIce(this));

        this.setBoxInteraction(new BoxInteractMove(this));
    }
}
