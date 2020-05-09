package Controller.Interact;

import Controller.Level.LevelController;
import Model.Elements.ElementModel;
import Model.Level.LevelModel;

public class InteractDestination extends Interact {
    public InteractDestination(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelController model) {
        model.addWater();
        model.move(position);
        //model.addPoints(1);
    }
}
