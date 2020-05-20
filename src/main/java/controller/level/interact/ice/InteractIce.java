package controller.level.interact.ice;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import controller.level.strategy.StrategyRegular;
import model.drawable.element.Ice;

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
}
