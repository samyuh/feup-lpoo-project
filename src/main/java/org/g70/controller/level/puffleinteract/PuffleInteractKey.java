package org.g70.controller.level.puffleinteract;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelItemsFacade;
import org.g70.controller.level.strategy.StrategyRegular;
import org.g70.model.drawable.element.Key;

public class PuffleInteractKey extends PuffleInteract<Key> {

    public PuffleInteractKey(Key element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelItemsFacade facade) {
        facade.meltPreviousIce();

        facade.movePuffle(position);
        controller.addScore(1,1);

        facade.removeKeyLock();

        facade.setStrategy(new StrategyRegular(facade));
    }
}
