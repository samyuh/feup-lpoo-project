package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelElementController;
import org.g70.controller.level.strategy.MeltNothing;
import org.g70.model.drawable.element.immovable.EmptyBlock;

public class InteractEmptyBlock extends Interact<EmptyBlock> {

    public InteractEmptyBlock(EmptyBlock element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelElementController elementController) {
        elementController.movePuffle(position);
        elementController.setMelt(new MeltNothing(elementController));
    }

    @Override
    public boolean executeBox(LevelElementController elementController) {
        elementController.moveBox(position);
        return true;
    }
}
