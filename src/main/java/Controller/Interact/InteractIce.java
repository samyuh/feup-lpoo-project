package Controller.Interact;

import Controller.Level.LevelUpdateModel;
import Model.Elements.ElementModel;
import Model.Elements.Ice;

public class InteractIce extends Interact {

    public InteractIce(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        model.removeIce((Ice) element);
        model.meltIce();
        model.move(position);
        //model.addPoints(1);
    }
}
