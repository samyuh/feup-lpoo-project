package controller.level.interact.items;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import controller.level.strategy.StrategyRegular;
import model.drawable.element.Coin;

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