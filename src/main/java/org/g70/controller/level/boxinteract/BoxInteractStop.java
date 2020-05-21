package org.g70.controller.level.boxinteract;

import org.g70.controller.level.LevelItemsFacade;
import org.g70.model.drawable.element.ElementModel;

public class BoxInteractStop extends BoxInteract {
    public BoxInteractStop(ElementModel element) {
        super(element);
    }

    @Override
    public boolean execute( LevelItemsFacade facade) {
        //Does nothing
        return false;
    }
}
