package org.g70.controller.level.interact;


import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.model.drawable.element.Box;

public class InteractBox extends Interact<Box> {

    public InteractBox(Box element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelFacade facade) {
        if(facade.boxLoop()) {

            facade.meltPreviousIce();
            controller.executePuffleMovement(position);
        }
        else {
            element.setInteraction(new InteractStop(element));
        }
    }

    @Override
    public boolean executeBox(LevelFacade facade) {
        return false;
    }
}
