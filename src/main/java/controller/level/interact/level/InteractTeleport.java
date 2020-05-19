package controller.level.interact.level;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import controller.level.strategy.StrategyRegular;
import model.drawable.element.Teleport;

public class InteractTeleport extends Interact<Teleport> {
    public InteractTeleport(Teleport element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        if(facade.isTeleportUsed()) {
            element.setInteraction(new InteractStop(element));
        }
        facade.meltPreviousIce();
        facade.move(position);
        facade.meltPreviousIce();
        position = facade.getTeleportPosition(element);
        facade.move(position);
        facade.setTeleportUsed(true);
        facade.getTeleport1().setColorForeground("#0000ff");
        facade.getTeleport2().setColorForeground("#0000ff");
        facade.addScore(1,1);

        facade.setStrategy(new StrategyRegular(facade));
    }
}
