package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class InteractStop extends Interact {

    public InteractStop(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        // if wall, water, or used teleport is found, nothing should be done
    }
}
