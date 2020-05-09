package Controller.Interact;

import Controller.Level.LevelController;
import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class InteractToughIce extends Interact {

    public InteractToughIce(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelController model) {
        model.addWater();
        model.move(position);
        //model.addPoints(1);
    }
}
