package org.g70.controller.level.puffleinteract;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyRegular;
import org.g70.model.drawable.element.Coin;

public class PuffleInteractCoin extends PuffleInteract<Coin> {

    public PuffleInteractCoin(Coin element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.movePuffle(position);
        controller.addScore(1,10);

        facade.removeCoin(element);

        facade.setStrategy(new StrategyRegular(facade));
    }
}