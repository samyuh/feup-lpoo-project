package org.g70.model.drawable.element.immovable;

import org.g70.controller.level.interact.InteractEmptyBlock;
import org.g70.model.Position;

public class EmptyBlock extends ImmovableElement {
    public EmptyBlock(Position position) {
        super("\u2588", "#53a6ed", position);

        interaction = new InteractEmptyBlock(this);
    }
}
