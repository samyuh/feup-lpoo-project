package Controller.Interact;

import Controller.Level.LevelUpdateModel;
import Model.Elements.ElementModel;

public class InteractDestination extends Interact {
    public InteractDestination(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        model.meltIce();
        model.move(position);
        //model.addPoints(1);
    }
}
