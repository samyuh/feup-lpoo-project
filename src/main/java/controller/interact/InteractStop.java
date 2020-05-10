package controller.interact;

import controller.level.LevelUpdateModel;
import model.elements.ElementModel;

public class InteractStop extends Interact {

    public InteractStop(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        // if wall, water, or used teleport is found, nothing should be done
    }
}
