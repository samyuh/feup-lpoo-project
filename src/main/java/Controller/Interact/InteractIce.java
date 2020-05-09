package Controller.Interact;

import Controller.Level.LevelController;
import Model.Elements.ElementModel;
import Model.Elements.Ice;
import Model.Level.LevelModel;

public class InteractIce extends Interact {

    public InteractIce(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelController model) {
        model.removeIce((Ice) element);
        model.addWater();
        model.move(position);
        //model.addPoints(1);
    }
}
