package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelElementController;
import org.g70.controller.level.strategy.MeltDoubleIce;
import org.g70.model.drawable.element.immovable.DoubleIce;

public class InteractDoubleIce extends Interact<DoubleIce> {

    public InteractDoubleIce(DoubleIce element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelElementController elementController) {
        elementController.movePuffle(position);
        controller.addScore(1,1);
        elementController.setMelt(new MeltDoubleIce(elementController));
    }

    @Override
    public boolean executeBox(LevelElementController elementController) {
        elementController.moveBox(position);
        return true;
    }
}
