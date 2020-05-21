package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.model.drawable.element.ElementModel;

public class InteractStop extends Interact<ElementModel> {

    public InteractStop(ElementModel element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        // if wall, water, or used teleport is found, nothing should be done
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        return false;
    }
}
