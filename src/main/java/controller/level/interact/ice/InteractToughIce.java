package controller.level.interact.ice;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import controller.level.strategy.StrategyToughIce;
import model.drawable.element.ToughIce;

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
}
