package org.g70.model.drawable.element;

import org.g70.controller.level.interact.InteractEmptyBlock;
import org.g70.model.Position;

public class EmptyBlock extends ElementModel {
    public EmptyBlock(Position position) {
        super("\u2588", "#53a6ed", position);

        this.setInteraction(new InteractEmptyBlock(this));
    }
}
