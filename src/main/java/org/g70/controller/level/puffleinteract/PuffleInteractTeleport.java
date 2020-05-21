package org.g70.controller.level.puffleinteract;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelItemsFacade;
import org.g70.controller.level.boxinteract.BoxInteractStop;
import org.g70.controller.level.strategy.StrategyRegular;
import org.g70.model.Position;
import org.g70.model.drawable.element.Teleport;

import java.util.List;

public class PuffleInteractTeleport extends PuffleInteract<Teleport> {
    public PuffleInteractTeleport(Teleport element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelItemsFacade facade) {
        facade.meltPreviousIce();

        facade.movePuffle(position);
        controller.addScore(1, 1);

        Position p2 = facade.getTeleportPosition(element);
        facade.movePuffle(p2);

        List<Teleport> tp = facade.getTeleport();

        for(Teleport teleport : tp) {
            teleport.setPuffleInteraction(new PuffleInteractStop(teleport));
            teleport.setBoxInteraction(new BoxInteractStop(teleport));
            teleport.setColorForeground("#0000ff");
        }

        facade.setStrategy(new StrategyRegular(facade));
    }
}
