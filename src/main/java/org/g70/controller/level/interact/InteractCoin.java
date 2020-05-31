package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelElementController;
import org.g70.controller.level.strategy.MeltIce;
import org.g70.model.drawable.element.immovable.Coin;

public class InteractCoin extends Interact<Coin> {

    public InteractCoin(Coin element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelElementController elementController) {
        elementController.movePuffle(position);
        controller.addScore(1,10);
        elementController.removeCoin(element);
        elementController.setMelt(new MeltIce(elementController));
    }

    @Override
    public boolean executeBox(LevelElementController elementController) {
        elementController.moveBox(position);
        return true;
    }
}