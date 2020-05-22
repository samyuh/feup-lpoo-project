package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyDoubleIce;
import org.g70.model.drawable.element.DoubleIce;

public class InteractToughIce extends Interact<DoubleIce> {

    public InteractToughIce(DoubleIce element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.movePuffle(position);
        controller.addScore(1,1);

        facade.setMeltStrategy(new StrategyDoubleIce(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        facade.moveBox(position);
        return true;
    }
}
