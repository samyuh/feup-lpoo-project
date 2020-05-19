package controller.level.interact.level;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import controller.level.strategy.StrategyRegular;
import model.Position;
import model.drawable.element.Teleport;

import java.util.List;

public class InteractTeleport extends Interact<Teleport> {
    public InteractTeleport(Teleport element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.move(position);
        facade.addScore(1, 1);

        Position p2 = facade.getTeleportPosition(element);
        facade.move(p2);

        List<Teleport> tp = facade.getTeleport();

        for(Teleport teleport : tp) {
            teleport.setInteraction(new InteractStop(tp.get(0)));
            teleport.setColorForeground("#0000ff");
        }

        facade.setStrategy(new StrategyRegular(facade));
    }
}
