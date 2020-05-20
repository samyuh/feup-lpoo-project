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

            facade.setStrategy(new StrategyRegular(facade));

            controller.executeMovement(position);
        }
        else {
            element.setInteraction(new InteractStop(element));
        }
    }

    @Override
    public void executeBox(LevelFacade facade) {
        // Este caso nunca vai ocorrer, porque a caixanunca pode interagir consigo mesma, sendo um objeto com um só instância
    }
}
