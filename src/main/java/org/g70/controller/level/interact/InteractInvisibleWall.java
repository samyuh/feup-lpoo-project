package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyNothing;
import org.g70.model.drawable.element.InvisibleWall;

public class InteractInvisibleWall extends Interact<InvisibleWall> {
    public InteractInvisibleWall(InvisibleWall element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();
        facade.movePuffle(position);
        controller.addScore(1,1);
        element.setInteraction(new InteractStop(element));
        facade.setMeltStrategy(new StrategyNothing(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        return false;
    }
}
