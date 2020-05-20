package org.g70.controller.level.boxInteract;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.model.drawable.element.ElementModel;

public class BoxInteractMove extends BoxInteract {
    public BoxInteractMove(ElementModel element) {
        super(element);
    }

    @Override
    public void execute( LevelFacade facade) {
        facade.makeBoxMove(position);
    }
}
