package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyIce;
import org.g70.model.drawable.element.immovable.Secret;

public class InteractSecret extends Interact<Secret> {
    public InteractSecret(Secret element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();
        facade.movePuffle(position);
        controller.addScore(1,1);
        controller.initSecretLevel();
        facade.setMeltStrategy(new StrategyIce(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        facade.moveBox(position);
        return true;
    }
}
