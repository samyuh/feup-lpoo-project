package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.MeltNothing;
import org.g70.model.drawable.element.immovable.EmptyBlock;

public class InteractEmptyBlock extends Interact<EmptyBlock> {

    public InteractEmptyBlock(EmptyBlock element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.movePuffle(position);
        facade.setMelt(new MeltNothing(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        facade.moveBox(position);
        return true;
    }
}
