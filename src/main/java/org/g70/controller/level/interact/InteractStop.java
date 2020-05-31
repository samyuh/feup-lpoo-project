package org.g70.controller.level.interact;

import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelElementController;
import org.g70.model.drawable.element.ElementModel;

public class InteractStop extends Interact<ElementModel> {

    public InteractStop(ElementModel element) {
        super(element);
    }

    @Override
    public void executePuffle(LevelController controller, LevelElementController elementController){}

    @Override
    public boolean executeBox(LevelElementController elementController) {
        return false;
    }
}
