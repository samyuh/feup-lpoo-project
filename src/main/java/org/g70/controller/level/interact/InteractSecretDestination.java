package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyRegular;
import org.g70.model.drawable.element.SecretDestination;

public class InteractSecretDestination extends Interact<SecretDestination> {
    public InteractSecretDestination(SecretDestination element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        controller.movePuffle(position);
        controller.addScore(1,1);

        controller.initSecretLevel();

        facade.setStrategy(new StrategyRegular(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        facade.moveBox(position);
        return true;
    }
}
