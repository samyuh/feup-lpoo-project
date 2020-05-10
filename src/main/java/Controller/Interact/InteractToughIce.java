package Controller.Interact;

import Controller.Level.LevelUpdateModel;
import Model.Elements.ElementModel;

public class InteractToughIce extends Interact {

    public InteractToughIce(ElementModel element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        model.meltIce();
        model.move(position);
        //model.addPoints(1);
    }
}
