package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.MeltIce;
import org.g70.model.drawable.element.immovable.Finish;

public class InteractFinish extends Interact<Finish> {
    public InteractFinish(Finish element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();
        facade.movePuffle(position);
        controller.addScore(1,1);
        controller.gameWon();
        facade.setMelt(new MeltIce(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        facade.moveBox(position);
        return true;
    }
}
