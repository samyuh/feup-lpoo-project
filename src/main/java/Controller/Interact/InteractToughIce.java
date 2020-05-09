package Controller.Interact;

import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class InteractToughIce extends Interact {

    public InteractToughIce(LevelModel m, ElementModel element) {
        super(m, element);
    }

    @Override
    public void execute() {
        model.addWater();
        model.move(position);
        model.addPoints(1);
    }
}
