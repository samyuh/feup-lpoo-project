package org.g70.controller.level.interact.ice;

import org.g70.controller.level.interact.Interact;
import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyToughIce;
import org.g70.model.drawable.element.ToughIce;

public class InteractToughIce extends Interact<ToughIce> {

    public InteractToughIce(ToughIce element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.move(position);
        controller.addScore(1,1);

        facade.setStrategy(new StrategyToughIce(facade));
    }

    @Override
    public void executeBox(LevelFacade facade) {
        System.out.println("Found InteractToughIce");
        facade.makeBoxMove(position);
    }
}
