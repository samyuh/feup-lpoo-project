package org.g70.controller.level.interact.box;


import org.g70.controller.level.interact.Interact;
import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.interact.level.InteractStop;
import org.g70.controller.level.strategy.StrategyRegular;
import org.g70.model.drawable.element.Box;

public class InteractBox extends Interact<Box> {

    public InteractBox(Box element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        if(facade.moveBox()) {
            facade.meltPreviousIce();

            facade.move(position);

            controller.addScore(1,1);

            facade.setStrategy(new StrategyRegular(facade));
        }
        else {
            element.setInteraction(new InteractStop(element));
        }
    }
}
