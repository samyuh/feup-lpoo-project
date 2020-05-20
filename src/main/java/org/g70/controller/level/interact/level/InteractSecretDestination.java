package org.g70.controller.level.interact.level;

import org.g70.controller.level.interact.Interact;
import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyRegular;
import org.g70.model.drawable.element.SecretDestination;

public class InteractSecretDestination extends Interact<SecretDestination> {
    public InteractSecretDestination(SecretDestination element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.move(position);
        controller.addScore(1,1);

        controller.secretLevel();

        facade.setStrategy(new StrategyRegular(facade));
    }
}
