package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyEmpty;
import org.g70.model.drawable.element.BoxFinalSquare;

public class InteractBoxFinalSquare extends Interact<BoxFinalSquare> {

    public InteractBoxFinalSquare(BoxFinalSquare element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        controller.movePuffle(position);

        facade.setStrategy(new StrategyEmpty(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        facade.moveBox(position);
        return true;
    }
}
