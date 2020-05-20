package org.g70.controller.level.interact.box;

import org.g70.controller.level.interact.Interact;
import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyEmpty;
import org.g70.model.drawable.element.BoxFinalSquare;

public class InteractBoxFinalSquare extends Interact<BoxFinalSquare> {

    public InteractBoxFinalSquare(BoxFinalSquare element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.move(position);

        facade.setStrategy(new StrategyEmpty(facade));
    }
}
