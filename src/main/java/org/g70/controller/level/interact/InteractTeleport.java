package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyRegular;
import org.g70.model.Position;
import org.g70.model.drawable.element.Teleport;

import java.util.List;

public class InteractTeleport extends Interact<Teleport> {
    public InteractTeleport(Teleport element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        controller.movePuffle(position);
        controller.addScore(1, 1);

        Position p2 = facade.getTeleportPosition(element);
        controller.movePuffle(p2);

        List<Teleport> tp = facade.getTeleport();

        for(Teleport teleport : tp) {
            teleport.setInteraction(new InteractStop(teleport));
            teleport.setColorForeground("#0000ff");
        }

        facade.setStrategy(new StrategyRegular(facade));
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        Position otherTeleport = facade.getTeleportPosition(element);
        facade.moveBox(otherTeleport);
        return true;
    }
}
