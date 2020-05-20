package org.g70.controller.level.interact.level;

import org.g70.controller.level.interact.Interact;
import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyRegular;
import org.g70.model.drawable.element.Destination;

public class InteractDestination extends Interact<Destination> {
    public InteractDestination(Destination element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.move(position);
        controller.addScore(1,1);

        controller.gameWon();

        facade.setStrategy(new StrategyRegular(facade));
    }

    @Override
    public void executeBox(LevelFacade facade) {
        System.out.println("Found InteractDestination");
    }

}
