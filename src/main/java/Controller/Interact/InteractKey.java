package Controller.Interact;

import Model.Elements.Key;
import Model.Level.LevelModel;

public class InteractKey extends Interact {

    public InteractKey(LevelModel m, Key element) {
        super(m,element);
    }

    @Override
    public void execute() {
        m.removeKeyLock();
        m.addWater();
        m.move(position);
        m.addScore(1);
    }
}
