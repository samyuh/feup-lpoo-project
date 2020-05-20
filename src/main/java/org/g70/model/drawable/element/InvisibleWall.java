package org.g70.model.drawable.element;

import org.g70.controller.level.boxInteract.BoxInteractMove;
import org.g70.controller.level.boxInteract.BoxInteractStop;
import org.g70.controller.level.interact.level.InteractInvisibleWall;
import org.g70.model.Position;

public class InvisibleWall extends ElementModel {
    public InvisibleWall(Position position) {
        super("\u2588", "#0065c6", position);
        this.setInteraction(new InteractInvisibleWall(this));

        this.setBoxInteraction(new BoxInteractMove(this));
    }
}
