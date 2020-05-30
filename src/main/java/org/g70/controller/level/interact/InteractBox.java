package org.g70.controller.level.interact;


import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelElementController;
import org.g70.model.drawable.element.movable.Box;

public class InteractBox extends Interact<Box> {

    public InteractBox(Box element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelElementController elementController) {
        if(elementController.boxLoop())
            controller.executePuffleMovement(position);
        else
            element.setInteraction(new InteractStop(element));

    }

    @Override
    public boolean executeBox(LevelElementController elementController) {
        return false;
    }
}
