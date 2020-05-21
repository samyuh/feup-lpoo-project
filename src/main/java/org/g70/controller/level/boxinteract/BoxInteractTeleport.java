package org.g70.controller.level.boxinteract;

import org.g70.controller.level.LevelFacade;
import org.g70.model.Position;
import org.g70.model.drawable.element.Teleport;

public class BoxInteractTeleport extends BoxInteract<Teleport> {
    public BoxInteractTeleport(Teleport element) {
        super(element);
    }

    @Override
    public boolean execute(LevelFacade facade) {
        Position otherTeleport = facade.getTeleportPosition(element);
        facade.moveBox(otherTeleport);
        return false;
    }
}