package org.g70.model.drawable.element;

import org.g70.controller.level.boxInteract.BoxInteractMove;
import org.g70.controller.level.boxInteract.BoxInteractStop;
import org.g70.controller.level.interact.items.InteractKey;
import org.g70.model.Position;

public class Key extends ElementModel {
    public Key(Position position) {
        super("K", "#A0522D", position);

        this.setInteraction(new InteractKey(this));

        this.setBoxInteraction(new BoxInteractMove(this));
    }
}
