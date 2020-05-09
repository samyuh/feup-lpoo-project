package Controller.Interact;

import Controller.Level.LevelController;
import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class InteractStop extends Interact {

    public InteractStop(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelController model) {
        // if wall, water, or used teleport is found, nothing should be done
    }
}
