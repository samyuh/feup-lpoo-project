package org.g70.controller.level.puffleinteract;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelItemsFacade;
import org.g70.model.drawable.element.ElementModel;

public class PuffleInteractStop extends PuffleInteract<ElementModel> {

    public PuffleInteractStop(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelItemsFacade facade) {
        // if wall, water, or used teleport is found, nothing should be done
    }
}
