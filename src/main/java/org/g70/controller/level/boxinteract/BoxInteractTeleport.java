package org.g70.controller.level.boxinteract;

import org.g70.controller.level.LevelItemsFacade;
import org.g70.model.Position;
import org.g70.model.drawable.element.Teleport;

public class BoxInteractTeleport extends BoxInteract<Teleport> {
    public BoxInteractTeleport(Teleport element) {
        super(element);
    }

    @Override
    public boolean execute(LevelItemsFacade facade) {
        Position otherTeleport = facade.getTeleportPosition(element);
        facade.moveBox(otherTeleport);
        return false;
    }
}