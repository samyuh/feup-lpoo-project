package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyNothing;
import org.g70.model.drawable.element.EmptyBlock;

public class InteractEmptyBlock extends Interact<EmptyBlock> {

    public InteractEmptyBlock(EmptyBlock element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();
        facade.movePuffle(position);
        facade.setMeltStrategy(new StrategyNothing(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        facade.moveBox(position);
        return true;
    }
}
