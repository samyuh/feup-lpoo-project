package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyIce;
import org.g70.model.drawable.element.Finish;

public class InteractDestination extends Interact<Finish> {
    public InteractDestination(Finish element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        controller.movePuffle(position);
        controller.addScore(1,1);

        controller.gameWon();

        facade.setStrategy(new StrategyIce(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        facade.moveBox(position);
        return true;
    }
}
