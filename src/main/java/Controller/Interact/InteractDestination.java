package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class InteractDestination extends Interact {
    public InteractDestination(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        m.addWater();
        m.move(position);
        m.addPoints(1);
    }
}
