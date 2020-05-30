package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.MeltIce;
import org.g70.model.Position;
import org.g70.model.drawable.element.immovable.Teleport;

import java.util.List;

public class InteractTeleport extends Interact<Teleport> {
    public InteractTeleport(Teleport element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        Position otherTeleport = facade.getTeleportPosition(element);
        facade.movePuffle(otherTeleport);

        controller.addScore(1, 1);

        List<Teleport> tp = facade.getTeleport();
        for(Teleport teleport : tp) {
            teleport.setInteraction(new InteractStop(teleport));
            teleport.setColorForeground("#0000ff");
        }
        facade.setMelt(new MeltIce(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        Position otherTeleport = facade.getTeleportPosition(element);
        facade.moveBox(otherTeleport);
        return true;
    }
}
