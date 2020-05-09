package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class InteractDestination extends Interact {
    public InteractDestination(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        model.addWater();
        model.move(position);
        model.addPoints(1);
    }
}
