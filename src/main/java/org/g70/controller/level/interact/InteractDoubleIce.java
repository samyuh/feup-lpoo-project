package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.MeltDoubleIce;

public class InteractDoubleIce extends Interact<org.g70.model.drawable.element.immovable.DoubleIce> {

    public InteractDoubleIce(org.g70.model.drawable.element.immovable.DoubleIce element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.movePuffle(position);
        controller.addScore(1,1);
        facade.setMelt(new MeltDoubleIce(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        facade.moveBox(position);
        return true;
    }
}
