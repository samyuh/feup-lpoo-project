package org.g70.controller.level.puffleinteract;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelItemsFacade;
import org.g70.controller.level.strategy.StrategyEmpty;
import org.g70.model.drawable.element.InvisibleWall;

public class PuffleInteractInvisibleWall extends PuffleInteract<InvisibleWall> {
    public PuffleInteractInvisibleWall(InvisibleWall element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelItemsFacade facade) {
        facade.meltPreviousIce();

        facade.movePuffle(position);
        controller.addScore(1,1);

        element.setPuffleInteraction(new PuffleInteractStop(element));

        facade.setStrategy(new StrategyEmpty(facade));
    }
}
