package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyToughIce;
import org.g70.model.drawable.element.ToughIce;

public class InteractToughIce extends Interact<ToughIce> {

    public InteractToughIce(ToughIce element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        controller.movePuffle(position);
        controller.addScore(1,1);

        facade.setStrategy(new StrategyToughIce(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        facade.moveBox(position);
        return true;
    }
}
