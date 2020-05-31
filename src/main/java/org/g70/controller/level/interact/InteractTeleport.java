package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelElementController;
import org.g70.controller.level.strategy.MeltIce;
import org.g70.model.Position;
import org.g70.model.drawable.element.immovable.Teleport;

import java.util.List;

public class InteractTeleport extends Interact<Teleport> {
    public InteractTeleport(Teleport element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelElementController elementController) {
        Position otherTeleport = elementController.getTeleportPosition(element);
        elementController.movePuffle(otherTeleport);

        controller.addScore(1, 1);

        List<Teleport> tp = elementController.getTeleport();
        for(Teleport teleport : tp) {
            teleport.setInteraction(new InteractStop(teleport));
            teleport.setColorForeground("#0000ff");
        }
        elementController.setMelt(new MeltIce(elementController));
    }

    @Override
    public boolean executeBox(LevelElementController elementController) {
        Position otherTeleport = elementController.getTeleportPosition(element);
        elementController.moveBox(otherTeleport);
        return true;
    }
}
