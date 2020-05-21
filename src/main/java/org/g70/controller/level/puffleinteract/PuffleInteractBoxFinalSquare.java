package org.g70.controller.level.puffleinteract;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyEmpty;
import org.g70.model.drawable.element.BoxFinalSquare;

public class PuffleInteractBoxFinalSquare extends PuffleInteract<BoxFinalSquare> {

    public PuffleInteractBoxFinalSquare(BoxFinalSquare element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.movePuffle(position);

        facade.setStrategy(new StrategyEmpty(facade));
    }
}
