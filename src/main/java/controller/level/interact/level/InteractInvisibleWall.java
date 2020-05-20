package controller.level.interact.level;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import controller.level.strategy.StrategyEmpty;
import model.drawable.element.InvisibleWall;

public class InteractInvisibleWall extends Interact<InvisibleWall> {
    public InteractInvisibleWall(InvisibleWall element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.move(position);
        controller.addScore(1,1);

        element.setInteraction(new InteractStop(element));

        facade.setStrategy(new StrategyEmpty(facade));
    }
}
