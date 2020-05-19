package controller.level.interact.level;

import controller.level.interact.Interact;
import controller.level.LevelController;
import controller.level.LevelFacade;
import model.drawable.element.ElementModel;

public class InteractStop extends Interact<ElementModel> {

    public InteractStop(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        // if wall, water, or used teleport is found, nothing should be done
    }
}
