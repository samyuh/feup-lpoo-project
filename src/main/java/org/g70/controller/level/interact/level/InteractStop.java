package org.g70.controller.level.interact.level;

import org.g70.controller.level.interact.Interact;
import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.model.drawable.element.ElementModel;

public class InteractStop extends Interact<ElementModel> {

    public InteractStop(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        // if wall, water, or used teleport is found, nothing should be done
    }
}
