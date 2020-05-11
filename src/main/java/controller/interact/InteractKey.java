package controller.interact;

import controller.level.LevelUpdateModel;
import model.drawable.element.Key;

public class InteractKey extends Interact {

    public InteractKey(Key element) {
        super(element);
    }

    @Override
    public void execute(LevelUpdateModel model) {
        model.removeKeyLock();
        model.meltIce();
        model.move(position);
        model.addScore(1,1);
    }
}
