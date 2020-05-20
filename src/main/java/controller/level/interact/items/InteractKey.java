package controller.level.interact.items;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import controller.level.strategy.StrategyRegular;
import model.drawable.element.Key;

public class InteractKey extends Interact<Key> {

    public InteractKey(Key element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.move(position);
        controller.addScore(1,1);

        facade.removeKeyLock();

        facade.setStrategy(new StrategyRegular(facade));
    }
}
