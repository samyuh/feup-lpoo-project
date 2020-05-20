package org.g70.controller.level.boxInteract;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.model.drawable.element.ElementModel;

public class BoxInteractStop extends BoxInteract {
    public BoxInteractStop(ElementModel element) {
        super(element);
    }

    @Override
    public void execute( LevelFacade facade) {
        //Does nothing
    }
}
