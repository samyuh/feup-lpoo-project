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
        if(!facade.isSecretFound()){
            facade.setSecretFound();
        }

        facade.meltPreviousIce();
        element.setInteraction(new InteractStop(element));
        facade.move(position);
        facade.addScore(1,1);

        facade.setStrategy(new StrategyEmpty(facade));
    }
}
