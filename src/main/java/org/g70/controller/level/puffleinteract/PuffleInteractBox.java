package org.g70.controller.level.puffleinteract;


import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.model.drawable.element.Box;

public class PuffleInteractBox extends PuffleInteract<Box> {

    public PuffleInteractBox(Box element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        if(facade.boxLoop()) {
            facade.meltPreviousIce();

            controller.executeMovement(position);
        }
        else {
            element.setPuffleInteraction(new PuffleInteractStop(element));
        }
    }
}
