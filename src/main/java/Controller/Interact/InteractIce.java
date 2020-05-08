package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Elements.Ice;
import Model.Level.LevelModel;

public class InteractIce extends Interact {

    public InteractIce(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        m.removeIce((Ice) element);
        m.addWater();
        m.move(position);
        m.addPoints(1);
    }
}
