package org.g70.controller.level.interact.items;

import org.g70.controller.level.interact.Interact;
import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyRegular;
import org.g70.model.drawable.element.Coin;

public class InteractCoin extends Interact<Coin> {

    public InteractCoin(Coin element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.move(position);
        controller.addScore(1,10);

        facade.removeCoin(element);

        facade.setStrategy(new StrategyRegular(facade));
    }
}