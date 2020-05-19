package controller.level.interact.level;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import controller.level.strategy.StrategyRegular;
import model.drawable.element.Destination;

public class InteractDestination extends Interact<Destination> {
    public InteractDestination(Destination element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.move(position);
        facade.addScore(1,1);

        controller.gameWon();

        facade.setStrategy(new StrategyRegular(facade));
    }
}
