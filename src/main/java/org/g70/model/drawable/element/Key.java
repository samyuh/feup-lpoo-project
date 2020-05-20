package org.g70.model.drawable.element;

import org.g70.controller.level.boxinteract.BoxInteractMove;
import org.g70.controller.level.puffleinteract.PuffleInteractKey;
import org.g70.model.Position;

public class Key extends ElementModel {
    public Key(Position position) {
        super("K", "#A0522D", position);

        this.setPuffleInteraction(new PuffleInteractKey(this));

        this.setBoxInteraction(new BoxInteractMove(this));
    }
}
