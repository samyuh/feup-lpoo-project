package org.g70.controller.level.puffleinteract;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyRegular;
import org.g70.model.drawable.element.SecretDestination;

public class PuffleInteractSecretDestination extends PuffleInteract<SecretDestination> {
    public PuffleInteractSecretDestination(SecretDestination element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.movePuffle(position);
        controller.addScore(1,1);

        controller.secretLevel();

        facade.setStrategy(new StrategyRegular(facade));
    }
}
