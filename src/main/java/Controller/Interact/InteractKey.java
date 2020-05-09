package Controller.Interact;

import Model.Elements.Key;
import Model.Level.LevelModel;

public class InteractKey extends Interact {

    public InteractKey(LevelModel m, Key element) {
        super(m,element);
    }

    @Override
    public void execute() {
        model.removeKeyLock();
        model.addWater();
        model.move(position);
        model.addPoints(1);
    }
}
