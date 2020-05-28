package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyIce;
import org.g70.model.drawable.element.immovable.Ice;

public class InteractIce extends Interact<Ice> {

    public InteractIce(Ice element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();
        facade.movePuffle(position);
        controller.addScore(1,1);
        facade.setMeltStrategy(new StrategyIce(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        facade.moveBox(position);
        return true;
    }
}
