package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.MeltIce;

public class InteractIce extends Interact<org.g70.model.drawable.element.immovable.Ice> {

    public InteractIce(org.g70.model.drawable.element.immovable.Ice element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();
        facade.movePuffle(position);
        controller.addScore(1,1);
        facade.setMelt(new MeltIce(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        facade.moveBox(position);
        return true;
    }
}
