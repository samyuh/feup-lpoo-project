package org.g70.controller.level.puffleinteract;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelItemsFacade;
import org.g70.controller.level.strategy.StrategyToughIce;
import org.g70.model.drawable.element.ToughIce;

public class PuffleInteractToughIce extends PuffleInteract<ToughIce> {

    public PuffleInteractToughIce(ToughIce element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelItemsFacade facade) {
        facade.meltPreviousIce();

        facade.movePuffle(position);
        controller.addScore(1,1);

        facade.setStrategy(new StrategyToughIce(facade));
    }
}
