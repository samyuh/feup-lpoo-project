package org.g70.controller.level.interact.ice;

import org.g70.controller.level.interact.Interact;
import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyRegular;
import org.g70.model.drawable.element.Ice;

public class InteractIce extends Interact<Ice> {

    public InteractIce(Ice element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.move(position);
        controller.addScore(1,1);

        facade.setStrategy(new StrategyRegular(facade));
    }

    @Override
    public void executeBox(LevelFacade facade) {
        System.out.println("Found InteractIce");
        facade.makeBoxMove(position);
    }
}
