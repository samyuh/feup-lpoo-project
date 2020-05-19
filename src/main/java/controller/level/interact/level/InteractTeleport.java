package controller.level.interact.level;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import controller.level.strategy.StrategyRegular;
import model.Position;
import model.drawable.element.Teleport;

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

        facade.getTeleport1().setInteraction(new InteractStop(facade.getTeleport1()));
        facade.getTeleport2().setInteraction(new InteractStop(facade.getTeleport2()));

        facade.getTeleport1().setColorForeground("#0000ff");
        facade.getTeleport2().setColorForeground("#0000ff");

        facade.setStrategy(new StrategyRegular(facade));
    }
}
