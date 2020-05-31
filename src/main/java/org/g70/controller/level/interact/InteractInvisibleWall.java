package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelElementController;
import org.g70.controller.level.strategy.MeltNothing;
import org.g70.model.drawable.element.immovable.InvisibleWall;

public class InteractInvisibleWall extends Interact<InvisibleWall> {
    public InteractInvisibleWall(InvisibleWall element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelElementController elementController) {
        elementController.movePuffle(position);
        controller.addScore(1,1);
        element.setInteraction(new InteractStop(element));
        elementController.setMelt(new MeltNothing(elementController));
    }

    @Override
    public boolean executeBox(LevelElementController elementController) {
        return false;
    }
}
