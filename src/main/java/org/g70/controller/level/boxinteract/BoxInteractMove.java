package org.g70.controller.level.boxinteract;

import org.g70.controller.level.LevelFacade;
import org.g70.model.drawable.element.ElementModel;

public class BoxInteractMove extends BoxInteract {
    public BoxInteractMove(ElementModel element) {
        super(element);
    }

    @Override
    public boolean execute(LevelFacade facade) {
        facade.moveBox(position);
        return true;
    }
}
