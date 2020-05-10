package Controller.Interact;

import Controller.Level.LevelUpdateModel;
import Model.Elements.ElementModel;

public class InteractStop extends Interact {

    public InteractStop(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        // if wall, water, or used teleport is found, nothing should be done
    }
}
