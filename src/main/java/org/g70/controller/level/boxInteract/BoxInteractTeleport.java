package org.g70.controller.level.boxInteract;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.model.Position;
import org.g70.model.drawable.element.ElementModel;
import org.g70.model.drawable.element.Teleport;

public class BoxInteractTeleport extends BoxInteract {
    public BoxInteractTeleport(ElementModel element) {
        super(element);
    }

    @Override
    public void execute( LevelFacade facade) {
        Position p3 = facade.getTeleportPosition((Teleport) element);
        facade.makeBoxMove(p3);
    }
}