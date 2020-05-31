package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelElementController;
import org.g70.controller.level.strategy.MeltIce;
import org.g70.model.drawable.element.immovable.Secret;

public class InteractSecret extends Interact<Secret> {
    public InteractSecret(Secret element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelElementController elementController) {
        elementController.movePuffle(position);
        controller.addScore(1,1);
        controller.initSecretLevel();
        elementController.setMelt(new MeltIce(elementController));
        element.setInteraction(new InteractStop(element));
    }

    @Override
    public boolean executeBox(LevelElementController elementController) {
        return false;
    }
}
