package Controller.Interact;

import Controller.Level.LevelController;
import Model.Elements.Key;
import Model.Level.LevelModel;

public class InteractKey extends Interact {

    public InteractKey(Key element) {
        super(element);
    }

    @Override
    public void execute(LevelController model) {
        model.removeKeyLock();
        model.addWater();
        model.move(position);
        //model.addPoints(1);
    }
}
