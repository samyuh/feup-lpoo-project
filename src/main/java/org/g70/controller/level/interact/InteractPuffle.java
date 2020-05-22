package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyIce;
import org.g70.model.drawable.element.Key;
import org.g70.model.drawable.element.Puffle;

public class InteractPuffle extends Interact<Puffle> {

    public InteractPuffle(Puffle element) {
            super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        // Não faz nada
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        return false;
    }
}
